package com.ms.framework;

import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/29 16:07
 */
public interface ContextStore {
    /**
     * 取得指定值
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * 是否存在指定值
     * @param key
     * @return
     */
    boolean containsKey(String key);

    /**
     * 添加一个值
     * @param key
     * @param value
     */
    void put(String key,Object value);

    /**
     * 添加一组值
     * @param dataMap
     */
    void putAll(Map<String,Object> dataMap);

    void remove(String key);

    Map<String,Object> toMap();

    Object getNativeStore();
}
