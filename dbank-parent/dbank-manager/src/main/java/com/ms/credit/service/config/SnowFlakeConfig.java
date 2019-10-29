package com.ms.credit.service.config;

import com.ms.credit.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/10/29 14:20
 */
@Configuration
public class SnowFlakeConfig {
    @Autowired
    private SnowFlakeProperties prop;

    /**
     * 注入SnowFlake（添加了机器Id及数据中心Id）
     * @return
     */
    @Bean
    public SnowFlake snowFlake() {
        return new SnowFlake(prop.getWorkerId(), prop.getDataCenterId());
    }
}
