package com.dean.demo.service.impl;

import com.dean.demo.enums.DbankExceptionEnum;
import com.dean.demo.exception.DbankException;
import com.dean.demo.service.ResourceFileService;
import com.dean.demo.utils.CurrentLineInfo;
import com.dean.demo.utils.LocalFileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/12/2 16:45
 */
@Service
public class ResourceFileServiceImpl implements ResourceFileService {
    private static final List<String> SUFFIX_ES_EXCEL = Arrays.asList(
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
            "application/vnd.dean-excel", "application/x-dos_ms_excel",
            "application/msexcel", "application/x-excel",
            "application/x-msexcel", "application/x-dean-excel"
    );
    private static final String SUFFIX_ES_TXT = "text/plain";
    private static final String ENCODING_TYPE_UTF8 = "UTF-8";
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public List<String> fileUpload(MultipartFile file) {
        List<String> userList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        try {
            if (file.isEmpty()) {
                //用户上传的文件内容为空
                logger.info("用户上传的文件内容为空：{}", CurrentLineInfo.getFileAddress());
                throw new DbankException(DbankExceptionEnum.FILE_CONTENT_IS_EMPTY);
            }
            InputStream in = file.getInputStream();
            //文件分类处理
            String fileContentType = file.getContentType();
            /*扩展名*/
            String suffix = LocalFileUtils.getExtensionName(file);
            if (SUFFIX_ES_EXCEL.contains(fileContentType)) {
                //用户上传的为excel文件，使用poi插件读取
                Workbook workbook = new XSSFWorkbook(in);
                Sheet sheet = workbook.getSheetAt(0);
                /*开始读取数据(跳过表头)*/
                String userTag;
                Integer totalRowNum = sheet.getLastRowNum();
                logger.info("数据总行数：{}",totalRowNum-1);
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    //获取到行
                    Row row = sheet.getRow(i);
                    if (row == null) {
                        continue;
                    }
                    /*默认读取第一列*/
                    Cell cell = row.getCell(0);
                    if(cell==null){
                        cell = row.getCell(1);
                    }
                    if(cell==null){
                        logger.info("空文件");
                        throw new DbankException(DbankExceptionEnum.FILE_CONTENT_IS_EMPTY);
                    }
                    userTag = cell.getStringCellValue();
                    userList.add(userTag);
                }
                //TODO  是否需要移除第一个数据?
                if (!CollectionUtils.isEmpty(userList)) {
                    userList.remove(0);
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
                    logger.error("txt文件读取失败", e.getStackTrace());
                    throw new DbankException(DbankExceptionEnum.FILE_READE_ERROR);
                }
            } else {
                //用户上传的文件格式不受支持
                logger.info("文件格式不受支持--{}", suffix + ";" + CurrentLineInfo.getFileAddress());
                throw new DbankException(DbankExceptionEnum.INVALID_FILE_TYPE);
            }
            /*移除空字符串*/
            for (String s : userList) {
                if (!StringUtils.isEmpty(s)) {
                    result.add(s);
                }
            }
        } catch (Throwable e) {
            //解析异常
            throw new DbankException(DbankExceptionEnum.MULTIMEDIA_FILE_PARSING_FAILED);
        }
        logger.info("成功上传" + result.size() + "条数据");
        return result;
    }
}