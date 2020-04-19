package com.dean.utils;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/25 18:22
 */
public class Properties {
    private static final String devFilePath = "/dev/env_p.properties";
    private static final String filePath = "/env_p.properties";
    private static java.util.Properties prop = new java.util.Properties();

    static {
        try {
            boolean isDev = false;
            InputStream in = null;
            if (isDev) {
                in = new FileInputStream(devFilePath);
            } else {
                in = new FileInputStream(filePath);
            }
            prop.load(in);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getSring(String key) {
        Object resultValue = prop.get(key);
        if (null != resultValue) {
            return (String) resultValue;
        }
        return null;
    }

    public static Integer getInteger(String key) {
        Object value = prop.get(key);
        if (null != value) {
            String intValue = (String) value;
            return Integer.parseInt(intValue);
        }
        return null;
    }
}
