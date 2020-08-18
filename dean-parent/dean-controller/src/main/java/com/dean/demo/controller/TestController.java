package com.dean.demo.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

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

    @RequestMapping(value = "/yuanTest",method = RequestMethod.POST)
    public ResponseEntity<Void> test2(@RequestParam("spbhList") List<String> str,@RequestParam("checkLogin")String isLogin) {
        System.out.println(str + isLogin);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public static void main(String[] args) {
        String[] obj = new String[]{"1","2"};
        Map<String, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        map.put("a","a");
        map.put("b",list);
        map.put("o",obj);
        Set<String> strings = map.keySet();
        for (String string : strings) {
            Object o = map.get(string);
            if(o==null){
                System.out.println("null");
            }else if(o.getClass().isArray()){
                System.out.println(o.toString());
            } else if(o instanceof List){
                System.out.println((List)o);
            }else {
                System.out.println(o);
            }
            System.out.println(o.getClass().isArray());
        }


        Double aDouble = Double.valueOf("66.666");
        System.out.println(aDouble);
    }
}
