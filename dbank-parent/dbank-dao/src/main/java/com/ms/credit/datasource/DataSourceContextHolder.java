package com.ms.credit.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/18 17:28
 * 动态切换数据源配置--AOP拦截器思想--将数据源信息存入线程局部变量threadLocal（注意内存泄漏问题）
 */
public class DataSourceContextHolder {
    private static final Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);
    private final static ThreadLocal<String> THREAD_DATA_SOURCE = new ThreadLocal<String>();

    public static void setDataSource(String dbType) {
        Assert.notNull(dbType, "DataSourceType cannot be null");
        THREAD_DATA_SOURCE.set(dbType);
    }

    public static String getDataSource() {
        return THREAD_DATA_SOURCE.get();

    }

    public static void clearDataSource() {
        THREAD_DATA_SOURCE.remove();
    }
}