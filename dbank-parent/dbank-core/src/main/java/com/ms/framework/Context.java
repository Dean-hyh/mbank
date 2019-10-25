package com.ms.framework;

import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/29 15:52
 */
public interface Context {
    /**
     * 取得指定值
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * 取得指定值
     * @param key
     * @param valueType
     * @param <T>
     * @return
     */
    <T> T get(String key,Class<T> valueType);

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
}
