package com.dean.demo.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/10/29 14:20
 */
@Component
public class SnowFlakeProperties {

    /**
     * 当前机器id
     */
    @Value("#{propertiesReader.workerId}")
    private long workerId;

    /**
     * 当前数据中心id
     */
    @Value("#{propertiesReader.dataCenterId}")
    private long dataCenterId;

    public SnowFlakeProperties() {
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }

    public long getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(long dataCenterId) {
        this.dataCenterId = dataCenterId;
    }
}