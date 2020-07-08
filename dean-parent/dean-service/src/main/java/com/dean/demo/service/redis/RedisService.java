package com.dean.demo.service.redis;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author yuanh
 * @version 1.0
 * @date 2019/3/28
 */
@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valueOperations;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 执行set指令
     *
     * @param key
     * @param value
     * @throws JsonProcessingException
     */
    public void set(String key, Object value) throws JsonProcessingException {
        if (!(value instanceof String)) {
            value = MAPPER.writeValueAsString(value);
        }
        this.valueOperations.set(key, (String) value);
    }

    /**
     * 执行set指令,设置生存时间
     *
     * @param key
     * @param value
     * @throws JsonProcessingException
     */
    public void set(String key, Object value, Long seconds) throws JsonProcessingException {
        if (!(value instanceof String)) {
            value = MAPPER.writeValueAsString(value);
        }
        this.valueOperations.set(key, (String) value, seconds, TimeUnit.SECONDS);
    }

    /**
     * 执行get指令
     *
     * @param key
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key, TypeReference<T> type) throws JsonParseException, JsonMappingException, IOException {
        String json = this.valueOperations.get(key);
        if (json == null) {
            return null;
        }
        if (type == null) {
            return (T) json;
        }
        return MAPPER.readValue(json, type);
    }

    /**
     * 执行del命令
     *
     * @param key
     */
    public void del(String key) {
        this.redisTemplate.delete(key);
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param seconds
     */
    public void expire(String key, Long seconds) {
        this.redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    public static void main(String[] args){
        System.out.println("BASE64解密：" + new String(Base64.decodeBase64("cnRkYzEyMzQ=")));
    }

}