package com.ms.credit.datasource;

import java.lang.annotation.*;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/10/22 16:11
 * DataSource注解，用于在方法上标注该方法读写要使用的数据库
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value();
}
