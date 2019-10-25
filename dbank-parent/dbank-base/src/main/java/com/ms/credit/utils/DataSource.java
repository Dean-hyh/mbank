package com.ms.credit.utils;

import java.lang.annotation.*;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/10/22 16:11
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value();
}
