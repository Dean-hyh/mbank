package com.ms.credit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/21 17:13
 */
@RestController
@RequestMapping("/testCtrl")
public class TestController {

    @RequestMapping(value = "/one/{num}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> testCtrl(@PathVariable("num") Integer num) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> resp = new HashMap<>();
        if (num % 2 == 1) {
            Map<Integer, Object> oddMap = getOddResp(num);
            resp.put("方法1", oddMap);
        } else {
            Map<Integer, Object> evenMap = getEvenResp(num);
            resp.put("方法2", evenMap);
        }
        result.put("输入的值是：", num);
        result.put("获取到的结果是：", resp);
        return ResponseEntity.ok(result);
    }

    private Map<Integer, Object> getEvenResp(Integer num) {
        Map<Integer, Object> evenMap = new HashMap<>();
        evenMap.put(num, "偶数，调用方法：getEvenResp");
        evenMap.put(num++,getObject());
        return evenMap;
    }

    private Map<Integer, Object> getOddResp(Integer num) {
        Map<Integer, Object> oddMap = new HashMap<>();
        oddMap.put(num, "奇数，调用方法：getOddResp");
        return oddMap;
    }

    private Map<String,Object> getObject() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("name","zhangsan");
        objectMap.put("age",20);
        objectMap.put("gender","未知");
        return objectMap;
    }
}
