package com.ms.credit;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/19 10:28
 */
public class MapTest {
    @Test
    public void test01(){
        //请求整体  key：request；value=reqMap
        Map<String, Object> context = new HashMap<>();
        //请求的内容
        Map<String, Object> reqMap = new HashMap<>();
        //请求体
        Map<String, Object> reqBody = new HashMap<>();
        reqMap.put("body", reqBody);
        //请求头
        Map<String, Object> reqHeader = new HashMap<>();
        reqMap.put("header",reqHeader);
        context.put("request",reqMap);
        System.out.println(context);
    }
}
