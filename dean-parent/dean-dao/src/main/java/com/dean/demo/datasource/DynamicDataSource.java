package com.dean.demo.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/18 17:28
 * 动态切换数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);

    @Override
    protected Object determineCurrentLookupKey() {
        // TODO Auto-generated method stub
        String dataSource = DataSourceContextHolder.getDataSource();
        if ("slave".equals(dataSource)) {
            logger.info("===========执行读库操作===========");
        }else if("master".equals(dataSource)){
            logger.info("===========执行修改数据库操作===========");
        }else {
            dataSource="master";
            logger.info("===========未知数据源===========");
        }
        return dataSource;
    }
}