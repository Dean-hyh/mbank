package com.dean.demo.controller;

import com.dean.demo.BaseController;
import com.dean.demo.enums.DbankExceptionEnum;
import com.dean.demo.exception.DbankException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/21 17:13
 */
@RestController
@RequestMapping("/thirdDream")
public class TestController extends BaseController {

    @RequestMapping(value = "/one/{num}/{test}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> testCtrl(@PathVariable("num") Integer num ,@PathVariable("test") String test) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> resp = new HashMap<>();
        if (num % 2 == 1) {
            Map<Integer, Object> oddMap = getOddResp(num);
            resp.put("方法1", oddMap);
        } else {
            Map<Integer, Object> evenMap = getEvenResp(num);
            resp.put("方法2", evenMap);
        }
        resp.put("test",test);
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

    private void printToFile(String date,String orderNo) {
        FileOutputStream o = null;
        String path="D:\\idea\\ideaSpace_bank\\bank\\src\\main\\resources\\file\\";
        String filename=date+"_subOrder.txt";
        System.out.println(filename);
        byte[] buff;
        try{
            File file = new File(path+filename);
            if(!file.exists()){
                file.createNewFile();
            }
            buff=orderNo.getBytes();
            o=new FileOutputStream(file,true);
            o.write(buff);
            o.write("\r\n".getBytes());
            o.flush();
            o.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/test6",method = RequestMethod.GET)
    public ResponseEntity<Void> test6(){
        throw new DbankException(DbankExceptionEnum.INVALID_PARAM_ERROR);
    }
}
