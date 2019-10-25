package com.ms.framework;

import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/29 16:07
 */
public interface ContextFilter {
    boolean filterPut(String key,Object value,AbstractContext context);

    boolean filterPutAll(Map<String,Object> dataMap,AbstractContext context);

    boolean filterRemove(String key,AbstractContext context);

}
