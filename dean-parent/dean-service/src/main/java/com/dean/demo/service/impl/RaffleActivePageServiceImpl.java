package com.dean.demo.service.impl;

import com.dean.demo.dao.RaffleActivePageDao;
import com.dean.demo.dao.RaffleDetailDao;
import com.dean.demo.enums.DbankExceptionEnum;
import com.dean.demo.exception.DbankException;
import com.dean.demo.pojo.DO.RaffleActivePage;
import com.dean.demo.pojo.DO.RaffleActivePageExample;
import com.dean.demo.pojo.DO.RaffleDetail;
import com.dean.demo.pojo.DO.RaffleDetailExample;
import com.dean.demo.pojo.DTO.RaffleActivePageDTO;
import com.dean.demo.pojo.DTO.RaffleDetailDTO;
import com.dean.demo.pojo.VO.RaffleActivePageVO;
import com.dean.demo.pojo.VO.RaffleDetailVO;
import com.dean.demo.service.RaffleActivePageService;
import com.dean.demo.utils.BeanHelper;
import com.dean.demo.utils.CurrentLineInfo;
import com.dean.demo.utils.JsonUtils;
import com.dean.demo.utils.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/12/16 13:48
 */
@Service
public class RaffleActivePageServiceImpl implements RaffleActivePageService {

    @Autowired
    private SnowFlake snowFlake;

    @Autowired
    private ResourceFileServiceImpl resourceFileService;

    private static final String IMG_PATH = "D:\\idea\\ideaSpace_dynamicDbbank\\dbank\\dbank-parent\\dbank-web\\src\\main\\webapp\\WEB-INF\\img\\";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX = "raffleActive:nameList:";

    /**
     * 所支持的图片格式
     */
    private static final List<String> SUFFIX_ES = Arrays.asList("image/jpeg", "image/png", "image/bmp", "image/gif");

    @Autowired
    private RaffleActivePageDao raffleActivePageDao;

    @Autowired
    private RaffleDetailDao raffleDetailDao;

    /**
     * 添加活动页面
     *
     * @param raffleActivePageDTO
     */
    @Override
    public void addRafflePage(RaffleActivePageDTO raffleActivePageDTO) {
        if (raffleActivePageDTO != null) {
            /*抽奖活动唯一标识*/
            final Long raffleActiveId = snowFlake.nextId();
            /*前端传送文件*/
            String nameListKey = "";
            String backgroundImgUrl = "";
            MultipartFile[] files = raffleActivePageDTO.getFiles();
            if (files != null && files.length == 2) {
                /*名单*/
                MultipartFile nameList = files[0];
                nameListKey = uploadNameList(nameList, raffleActiveId);

                /*背景图片*/
                MultipartFile backgroundImg = files[1];
                backgroundImgUrl = uploadImg(backgroundImg);
            } else {
                throw new DbankException(DbankExceptionEnum.INVALID_FILE_TYPE);
            }
            /*活动明细*/
            List<RaffleDetailDTO> raffleDetailList = raffleActivePageDTO.getRaffleDetailList();
            if (CollectionUtils.isEmpty(raffleDetailList)) {
                logger.error("抽奖详情参数有误！");
                throw new DbankException(DbankExceptionEnum.INVALID_PARAM_ERROR);
            }
            Integer totalPrizeQuota = 0;
            Integer totalBatch = 0;
            Integer awards = 0;
            for (RaffleDetailDTO raffleDetailDTO : raffleDetailList) {
                //TODO 处理一下逻辑--非空判断

                if (raffleDetailDTO != null && !StringUtils.isEmpty(raffleDetailDTO.getAwardsName())) {
                    final Long raffleSetailId = snowFlake.nextId();
                    RaffleDetail raffleDetail = BeanHelper.copyProperties(raffleDetailDTO, RaffleDetail.class);
                    raffleDetail.setRaffleDetailId(raffleSetailId);
                    raffleDetail.setCreateUser(raffleActivePageDTO.getCreateUser());
                    raffleDetail.setCreateTime(new Date());
                    raffleDetail.setUpdateTime(new Date());
                    raffleDetail.setRaffleActiveId(raffleActiveId);
                    /*初始状态*/
                    raffleDetail.setRaffleDetailStatus(0);
                    totalPrizeQuota += raffleDetail.getPrizeQuota();
                    totalBatch += raffleDetail.getBetch();
                    int insert = raffleDetailDao.insert(raffleDetail);
                    if (insert < 0) {
                        logger.error("新增抽奖信息详情失败");
                        throw new DbankException(DbankExceptionEnum.INSERT_OPERATION_FAIL);
                    }
                    awards++;
                }
            }

            /*其他数据*/
            RaffleActivePage raffleActivePageDO = BeanHelper.copyProperties(raffleActivePageDTO, RaffleActivePage.class);
            raffleActivePageDO.setRaffleActiveId(raffleActiveId);
            raffleActivePageDO.setBackgroundImgUrl(backgroundImgUrl);
            raffleActivePageDO.setNamelistKey(nameListKey);
            raffleActivePageDO.setCreateTime(new Date());
            raffleActivePageDO.setUpdateTime(new Date());
            raffleActivePageDO.setRaffleStatus(0);
            raffleActivePageDO.setAwards(awards);
            /*总抽奖人数*/
            raffleActivePageDO.setTotalPrizeQuota(totalPrizeQuota);
            /*总抽奖批次*/
            raffleActivePageDO.setTotalBatch(totalBatch);


            int insert = raffleActivePageDao.insert(raffleActivePageDO);
            if (insert < 0) {
                throw new DbankException(DbankExceptionEnum.INSERT_OPERATION_FAIL);
            }
            logger.info("添加成功,添加的数据：" + JsonUtils.toString(raffleActivePageDO));
        } else {
            throw new DbankException(DbankExceptionEnum.INVALID_PARAM_ERROR);
        }
    }

    /**
     * 上传图片
     *
     * @param backgroundImg
     * @return
     */
    private String uploadImg(MultipartFile backgroundImg) {

        //1.判断所传图片格式是否受支持，不支持则不做业务处理
        String fileContentType = backgroundImg.getContentType();
        if (!SUFFIX_ES.contains(fileContentType)) {
            throw new DbankException(DbankExceptionEnum.INVALID_FILE_TYPE);
        }

        //2.判断文件内容
        BufferedImage image = null;
        try {
            image = ImageIO.read(backgroundImg.getInputStream());
        } catch (IOException e) {
            throw new DbankException(DbankExceptionEnum.INVALID_FILE_TYPE);
        }
        if (image == null) {
            throw new DbankException(DbankExceptionEnum.INVALID_FILE_TYPE);
        }

        //3.上传图片
        File file = new File(IMG_PATH);
        FileOutputStream fos = null;
        InputStream in = null;
        //文件存储路径
        final String backgroundUrl = IMG_PATH + UUID.randomUUID().toString() + "_" + backgroundImg.getOriginalFilename();
        try {
            if (!file.exists() && !file.isDirectory()) {
                file.mkdir();
            }
            fos = new FileOutputStream(backgroundUrl);
            in = backgroundImg.getInputStream();
            byte[] bytes = new byte[1024 * 1024];
            int byteRead = 0;
            while ((byteRead = in.read(bytes)) != -1) {
                fos.write(bytes, 0, byteRead);
                fos.flush();
            }
        } catch (Exception e) {
            logger.error("背景图片上传失败：--" + e.getMessage());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return backgroundUrl;
    }


    /**
     * 缓存名单--超时时间30分钟
     *
     * @param nameList
     * @param raffleActiveId
     * @return
     */
    private String uploadNameList(MultipartFile nameList, Long raffleActiveId) {
        List<String> list = resourceFileService.fileUpload(nameList);
        String redisNameList = JsonUtils.toString(list);
        String nameListUrl = KEY_PREFIX + raffleActiveId;
        redisTemplate.opsForValue().set(KEY_PREFIX + raffleActiveId, redisNameList, 30L, TimeUnit.MINUTES);
        return nameListUrl;
    }

    /**
     * 查询活动列表
     *
     * @return
     */
    @Override
    public List<RaffleActivePageVO> getRaffleList() {
        RaffleActivePageExample pageExample = new RaffleActivePageExample();
        pageExample.setOrderByClause("create_time desc");
        List<RaffleActivePageVO> raffleList = null;
        try {
            List<RaffleActivePage> rafflePageList = raffleActivePageDao.selectByExample(pageExample);
            raffleList = BeanHelper.copyWithCollection(rafflePageList, RaffleActivePageVO.class);
            if(!CollectionUtils.isEmpty(raffleList)){
                for (RaffleActivePageVO raffleActivePageVO : raffleList) {
                    RaffleDetailExample detailExample = new RaffleDetailExample();
                    detailExample.createCriteria().andRaffleActiveIdEqualTo(raffleActivePageVO.getRaffleActiveId());
                    List<RaffleDetail> raffleDetails = raffleDetailDao.selectByExample(detailExample);
                    List<RaffleDetailVO> detailVOList = BeanHelper.copyWithCollection(raffleDetails, RaffleDetailVO.class);
                    raffleActivePageVO.setRaffleDetailVoList(detailVOList);
                }
            }
        } catch (Exception e) {
            logger.error("活动列表查询失败{}",e);
            throw new DbankException(DbankExceptionEnum.CATEGORY_NOT_FOUND);
        }

        return raffleList;
    }

    /**
     * 修改页面
     *
     * @param raffleActiveId
     * @return
     */
    @Override
    public RaffleActivePageDTO getRaffleById(Long raffleActiveId) {
        RaffleActivePage raffleActivePage = raffleActivePageDao.selectByPrimaryKey(raffleActiveId);
        RaffleDetailExample example = new RaffleDetailExample();
        example.createCriteria().andRaffleActiveIdEqualTo(raffleActiveId);
        List<RaffleDetail> raffleDetails = raffleDetailDao.selectByExample(example);
        if (raffleActivePage == null) {
            throw new DbankException(DbankExceptionEnum.APPLICATION_NOT_FOUND);
        }
        RaffleActivePageDTO raffleActivePageDTO = BeanHelper.copyProperties(raffleActivePage, RaffleActivePageDTO.class);
        List<RaffleDetailDTO> raffleDetailDTOS = BeanHelper.copyWithCollection(raffleDetails, RaffleDetailDTO.class);
        raffleActivePageDTO.setRaffleDetailList(raffleDetailDTOS);
        return raffleActivePageDTO;
    }

    /**
     * 删除活动
     * @param raffleActiveId
     */
    @Override
    public void deleteRaffleActive(Long raffleActiveId) {
        /*1.删除奖品明细*/
        try {
        int isDetailDelete = raffleDetailDao.deleteByRaffleActiveId(raffleActiveId);
            if(isDetailDelete<0){
                logger.error("抽奖活动明细删除失败" + CurrentLineInfo.getFileAddress());
                throw new DbankException(DbankExceptionEnum.DELETE_OPERATION_FAIL);
            }
        } catch (Exception e) {
            logger.error("抽奖活动明细删除失败" + e.getMessage() + CurrentLineInfo.getFileAddress());
            throw new DbankException(DbankExceptionEnum.DELETE_OPERATION_FAIL);
        }

        /*2.删除抽奖活动*/
        try {
            int i = raffleActivePageDao.deleteByPrimaryKey(raffleActiveId);
            if(i<0){
                logger.error("抽奖活动删除失败" + CurrentLineInfo.getFileAddress());
                throw new DbankException(DbankExceptionEnum.DELETE_OPERATION_FAIL);
            }
        } catch (Exception e) {
            logger.error("抽奖活动删除失败" + e.getMessage() + CurrentLineInfo.getFileAddress());
            throw new DbankException(DbankExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }
}
