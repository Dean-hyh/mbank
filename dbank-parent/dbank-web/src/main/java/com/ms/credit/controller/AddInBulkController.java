package com.ms.credit.controller;

import com.ms.credit.BaseController;
import com.ms.credit.enums.DbankExceptionEnum;
import com.ms.credit.exception.DbankException;
import com.ms.credit.utils.CurrentLineInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/28 11:18
 * 批量添加用户列表
 */
@RestController
@RequestMapping("/addList")
public class AddInBulkController extends BaseController {

    private static final List<String> SUFFIX_ES_EXCEL = Arrays.asList("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                                                                      "application/vnd.ms-excel","application/x-dos_ms_excel",
                                                                      "application/msexcel","application/x-excel",
                                                                      "application/x-msexcel","application/x-ms-excel"
                                                                      );
    private static final String SUFFIX_ES_TXT = "text/plain";
    private static final String ENCODING_TYPE_UTF8 = "UTF-8";
    //private static final String ENCODING_TYPE_GBK = "GBK";
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
     * 下载文件模板
     *
     * @param fileId 模板id
     * @return 下载结果
     */
    @RequestMapping(value = "/downloadFileModel/{fileId}", method = RequestMethod.GET)
    public ResponseEntity<Void> downloadFileModel(@PathVariable("fileId") Integer fileId) {
        try {
            String path = "";
            HttpSession session = request.getSession();
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
     * 解析用户上传的文件
     *
     * @param file 用户上传的文件
     * @return 返回列表信息给客户端
     */
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public ResponseEntity<List<String>> fileUpload(@RequestParam("files") MultipartFile file) {
        List<String> userList = new ArrayList<>();
        try {
            if (file.isEmpty()) {
                //用户上传的文件内容为空
                logger.info("用户上传的文件内容为空：{}",CurrentLineInfo.getFileAddress());
                throw new DbankException(DbankExceptionEnum.FILE_CONTENT_IS_EMPTY);
            }
            InputStream in = file.getInputStream();
            //文件分类处理
            String fileContentType = file.getContentType();
            if (SUFFIX_ES_EXCEL.contains(fileContentType)) {
                //用户上传的为excel文件，使用poi插件读取
                /*获取工作表*/
                Workbook workbook = new XSSFWorkbook(file.getInputStream());
                /*读取第一张表 sheet0*/
                Sheet sheet = workbook.getSheetAt(0);
                /*开始读取数据(跳过表头)*/
                String userTag = null;
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    //获取到行
                    Row row = sheet.getRow(i);
                    if(row==null){
                        continue;
                    }
                    Cell cell = row.getCell(0);
                    userTag = cell.getStringCellValue();
                    userList.add(userTag);
                }

            } else if (SUFFIX_ES_TXT.equals(fileContentType)) {
                //用户上传的为txt文件，使用流读取
                try {
                    InputStreamReader isr = new InputStreamReader(in, ENCODING_TYPE_UTF8);
                    BufferedReader br = new BufferedReader(isr);
                    String str;
                    while ((str = br.readLine()) != null) {
                        userList.add(str);
                    }
                } catch (Exception e) {
                    logger.error("txt文件读取失败{}", e);
                }
            } else {
                //用户上传的文件格式不受支持
                logger.info("文件格式不受支持:{}", fileContentType, CurrentLineInfo.getFileAddress());
                throw new DbankException(DbankExceptionEnum.INVALID_FILE_TYPE);
            }
        } catch (Throwable e) {
            //解析异常
            throw new DbankException(DbankExceptionEnum.MULTIMEDIA_FILE_PARSING_FAILED);
        }
        return ResponseEntity.ok(userList);
    }
}
