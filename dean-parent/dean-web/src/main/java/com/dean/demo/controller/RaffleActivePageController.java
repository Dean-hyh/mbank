package com.dean.demo.controller;

import com.dean.demo.BaseController;
import com.dean.demo.enums.DbankExceptionEnum;
import com.dean.demo.exception.DbankException;
import com.dean.demo.pojo.DTO.RaffleActivePageDTO;
import com.dean.demo.pojo.VO.RaffleActivePageVO;
import com.dean.demo.service.RaffleActivePageService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/12/13 17:22
 */
@RestController
@RequestMapping("/raffleActive")
public class RaffleActivePageController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RaffleActivePageService raffleActivePageService;

    /**
     * 添加页面
     *
     * @param raffleActivePageDTO
     * @return
     */
    @RequestMapping(value = "/addRaffleActive", method = RequestMethod.POST)
    public ResponseEntity<Void> addRaffleActive(RaffleActivePageDTO raffleActivePageDTO) {
        raffleActivePageDTO.setCreateUser(username);
        try {
            raffleActivePageService.addRafflePage(raffleActivePageDTO);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new DbankException(DbankExceptionEnum.INSERT_OPERATION_FAIL);
        }
        logger.info("页面添加成功");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 查看活动列表
     */
    @RequestMapping(value = "/raffleList", method = RequestMethod.GET)
    public ResponseEntity<List<RaffleActivePageVO>> getRaffleList() {
        List<RaffleActivePageVO> raffleList = raffleActivePageService.getRaffleList();
        return ResponseEntity.ok(raffleList);
    }

    /**
     * 查看单个活动明细
     *
     * @param raffleActiveId
     * @return
     */
    @RequestMapping(value = "/raffleEdit", method = RequestMethod.GET)
    public ResponseEntity<RaffleActivePageDTO> getRaffleById(@Param("raffleActiveId") Long raffleActiveId) {
        if (StringUtils.isEmpty(raffleActiveId)) {
            throw new DbankException(DbankExceptionEnum.INVALID_PARAM_ERROR);
        }
        RaffleActivePageDTO raffleActivePageDTO = raffleActivePageService.getRaffleById(raffleActiveId);
        return ResponseEntity.ok(raffleActivePageDTO);
    }

    /**
     * 提交修改
     * TODO 暂不提供
     *
     * @param raffleActivePageDTO 接收前端回传数据
     * @return
     */
    @RequestMapping(value = "/updateRaffle", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateRaffle(RaffleActivePageDTO raffleActivePageDTO) {

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 删除活动
     *
     * @param raffleActiveId 活动id
     * @return 空值
     */
    @RequestMapping(value = "/raffleDelete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> raffleDelete(@Param("raffleActiveId") Long raffleActiveId) {
        if (StringUtils.isEmpty(raffleActiveId)) {
            throw new DbankException(DbankExceptionEnum.INVALID_PARAM_ERROR);
        }
        raffleActivePageService.deleteRaffleActive(raffleActiveId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
