package com.ms.credit.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/29 10:07
 * 文件处理工具类
 */
public class LocalFileUtils {
    /**
     * 获取无后缀文件名
     *
     * @param fileName
     * @return
     */
    public static String getPreFileNameNoEx(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return "文件名不可为空";
        }
        return fileName.trim().substring(0, fileName.lastIndexOf("."));
    }

    public static String getPreFileNameNoEx(MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        String fileName = file.getOriginalFilename();
        if (StringUtils.isEmpty(fileName)) {
            return "文件名不可为空";
        }
        return fileName.trim().substring(0, fileName.lastIndexOf("."));
    }

    /**
     * 获取文件扩展名
     *
     * @param fileName 文件名
     * @return
     */
    public static String getExtensionName(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return "文件名不可为空";
        }
        return fileName.trim().substring(fileName.lastIndexOf("."), fileName.length());
    }

    /**
     * 获取文件扩展名
     * @param file 多媒体文件
     * @return
     */
    public static String getExtensionName(MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        String fileName = file.getOriginalFilename();
        if (StringUtils.isEmpty(fileName)) {
            return "文件名不可为空";
        }
        return fileName.trim().substring(fileName.lastIndexOf("."), fileName.length());
    }
}
