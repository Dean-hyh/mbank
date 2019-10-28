package com.ms.credit.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/18 17:28
 * 动态切换数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
    // TODO Auto-generated method stub
        String dataSource = DataSourceContextHolder.getDataSource();
        System.out.println("操作用到的数据库：" + dataSource );
        return dataSource;
    }
}