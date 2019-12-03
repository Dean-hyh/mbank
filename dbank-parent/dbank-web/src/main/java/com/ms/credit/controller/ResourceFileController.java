package com.ms.credit.controller;

import com.ms.credit.BaseController;
import com.ms.credit.enums.DbankExceptionEnum;
import com.ms.credit.exception.DbankException;
import com.ms.credit.pojo.VO.LuckyEmpVO;
import com.ms.credit.pojo.info.FtpInfo;
import com.ms.credit.service.ResourceFileService;
import com.ms.credit.utils.CurrentLineInfo;
import com.ms.credit.utils.ftp.FtpFileUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/28 11:18
 * 批量处理用户列表
 */
@RestController
@RequestMapping("/resourceFile")
public class ResourceFileController extends BaseController {

    @Autowired
    private ResourceFileService resourceFileService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 跳转到上传页面
     *
     * @return 跳转结果
     */
    @RequestMapping(value = "/toAddPage", method = RequestMethod.GET)
    public ResponseEntity<Void> toAddPage() {
        return ResponseEntity.ok().build();
    }

    /**
     * 文件模板下载
     *
     * @param fileId 模板id
     * @return 下载结果
     */
    @RequestMapping(value = "/downloadTemplate/{tempId}", method = RequestMethod.GET)
    public ResponseEntity<Void> downloadFileModel(@PathVariable("fileId") Integer fileId) {
        try {
            String path;
            if (fileId == 0) {
                path = session.getServletContext().getRealPath("WEB-INF/make/xlsprint/registForm.xlsx");
            } else if (fileId == 1) {
                path = session.getServletContext().getRealPath("WEB-INF/make/txtprint/registList.txt");
            } else {
                throw new DbankException(DbankExceptionEnum.CATEGORY_NOT_FOUND);
            }
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
            // 一个流 文件输出流
            // 两个头 一个是文件的打开方式（附件形式attachment，页面打开inline）   mime类型：常用文件的mime类型可以不写
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            String fileType = path.substring(path.lastIndexOf(".") + 1, path.length());
            //文件的打开方式
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("报名表模板." + fileType, "UTF-8"));
            byte[] bArr = new byte[1024 * 8];
            int len = 0;
            while ((len = bis.read(bArr)) != -1) {
                bos.write(bArr, 0, len);
            }
            bos.close();
            bis.close();

        } catch (Exception e) {
            throw new DbankException(DbankExceptionEnum.FILE_WRITER_ERROR);
        }
        return ResponseEntity.ok().build();
    }

    /**
     * 本地文件上传
     *
     * @param file 用户上传的文件
     * @return 返回列表信息给客户端
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<List<String>> fileUpload(@RequestParam("files") MultipartFile file) {
        List<String> userList = resourceFileService.fileUpload(file);
        return ResponseEntity.ok(userList);
    }

    /**
     * 下载中奖名单
     *
     * @return
     */
    @RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
    public ResponseEntity<Void> downloadFile() throws FileNotFoundException {
        //TODO 真实数据需从数据库或缓存中查询
        LuckyEmpVO le1 = new LuckyEmpVO("APP活动1", "1", "特等奖", "周星驰", new Date(), "5");
        LuckyEmpVO le2 = new LuckyEmpVO("APP活动2", "2", "一等奖", "陈小春", new Date(), "5");
        LuckyEmpVO le3 = new LuckyEmpVO("APP活动3", "3", "二等奖", "古天乐", new Date(), "5");
        LuckyEmpVO le4 = new LuckyEmpVO("APP活动4", "4", "三等奖", "刘德华", new Date(), "5");
        LuckyEmpVO le5 = new LuckyEmpVO("APP活动5", "5", "三等奖", "谢霆锋", new Date(), "5");
        List<LuckyEmpVO> luckyEmpVOList = new ArrayList<>();
        luckyEmpVOList.add(le1);
        luckyEmpVOList.add(le2);
        luckyEmpVOList.add(le3);
        luckyEmpVOList.add(le4);
        luckyEmpVOList.add(le5);

        try {
            /*读取模板*/
            String path = session.getServletContext().getRealPath("WEB-INF/make/xlsprint/LUCKYRMP.xlsx");
            final XSSFWorkbook workbook;
            try {
                workbook = new XSSFWorkbook(new FileInputStream(path));
            } catch (IOException e) {
                logger.error("读取模板异常", CurrentLineInfo.getFileAddress() + e);
                throw new DbankException(DbankExceptionEnum.FILE_READE_ERROR);
            }
            XSSFSheet sheet = workbook.getSheetAt(0);

            //第一行（标题--合并的单元格）-------------------------
            Row bigTitleRow = sheet.getRow(0);
            //TODO 拼接活动名称--设置后管可配置
            String activityName = "专宠礼包";
            bigTitleRow.getCell(1).setCellValue(activityName + "抽奖活动中奖名单");

            //第二行（表头字段）-------------------------
            Row titleRow = sheet.getRow(1);

            //正文-------------------------
            Row textRow = sheet.getRow(2);

            /*获取内容中的格式,存入样式数组中*/
            CellStyle[] cellStyles = new CellStyle[5];
            for (int i = 1; i < 6; i++) {
                CellStyle cellStyle = textRow.getCell(i).getCellStyle();
                //将样式存入数组
                cellStyles[i - 1] = cellStyle;
            }
            int rowIndex = 2;
            Cell cell = null;
            for (LuckyEmpVO luckyEmpVO : luckyEmpVOList) {
                Row row = sheet.createRow(rowIndex);
                row.setHeightInPoints(16);

                /*序号*/
                cell = row.createCell(1);
                cell.setCellStyle(cellStyles[0]);
                cell.setCellValue(luckyEmpVO.getSeriaNo());

                /*中奖名次*/
                cell = row.createCell(2);
                cell.setCellStyle(cellStyles[1]);
                cell.setCellValue(luckyEmpVO.getGrade());

                /*中奖人*/
                cell = row.createCell(3);
                cell.setCellStyle(cellStyles[2]);
                cell.setCellValue(luckyEmpVO.getEmpName());

                /*抽奖日期*/
                cell = row.createCell(4);
                cell.setCellStyle(cellStyles[3]);
                cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(luckyEmpVO.getAwardDate()));

                /*奖品内容*/
                cell = row.createCell(5);
                cell.setCellStyle(cellStyles[4]);
                cell.setCellValue(luckyEmpVO.getPrize());

                rowIndex++;
            }

            /*输出流*/
            ServletOutputStream outputStream = response.getOutputStream();
            /*添加响应文件头-1.打开方式（附件形式attachment，页面打开inline）/2.文件类型（mime类型）*/
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(activityName + "活动中奖名单.xlsx", "UTF-8"));
            workbook.write(outputStream);
        } catch (Exception e) {
            logger.error("名单下载异常：", e);
            throw new DbankException(DbankExceptionEnum.FILE_READE_ERROR);
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/uploadFileFromFtp/{fileName}",method = RequestMethod.POST)
    public ResponseEntity<List<String>> uploadFileFromFtp(@PathVariable("fileName") String fileName){
        FtpInfo ftpInfo = new FtpInfo();
        ftpInfo.setHost("192.168.230.129");
        ftpInfo.setPort(60021);
        ftpInfo.setUsername("test");
        ftpInfo.setPassword("hz13554");
        ftpInfo.setRemoteDir("/data/files/");
        String path = "D:\\idea\\ideaSpace_dynamicDbbank\\dbank\\dbank-parent\\dbank-web\\src\\main\\webapp\\WEB-INF\\data\\";
        String newFileName = fileName+".txt";
        try {
            boolean downfile = FtpFileUtil.downfile(ftpInfo, path, newFileName);
        } catch (Exception e) {
            logger.info("ftp文件下载失败");
            throw new DbankException(DbankExceptionEnum.FILE_CONTENT_IS_EMPTY);
        }
        List<String> userList = new ArrayList<>();
        return ResponseEntity.ok(userList);
    }
}
