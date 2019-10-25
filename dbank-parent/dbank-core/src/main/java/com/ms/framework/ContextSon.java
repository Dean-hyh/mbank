package com.ms.framework;

import com.alibaba.dubbo.common.json.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/29 15:57
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ContextSon implements Context {

    Map<String, Object> content = new HashMap<String, Object>();

    /**
     * 初始化
     */
    public ContextSon() {
        Map reqMap = new HashMap<>();
        Map reqBody = new HashMap();
        reqMap.put("body", reqBody);
        Map reqHeader = new HashMap();
        reqMap.put("header", reqHeader);
        content.put("request", reqMap);
    }

    @Override
    public Object get(String key) {
        return content.get(key);
    }

    @Override
    public <T> T get(String key, Class<T> valueType) {
        return (T) content.get(key);
    }

    @Override
    public boolean containsKey(String key) {
        return content.containsKey(key);
    }

    @Override
    public void put(String key, Object value) {
        content.put(key, value);
    }

    @Override
    public void putAll(Map<String, Object> dataMap) {
        content.putAll(dataMap);
    }

    @Override
    public String toString() {
        return "ContextSon{" +
                "content=" + content +
                '}';
    }
}
