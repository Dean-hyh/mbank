package com.dean.demo.controller;

import com.dean.demo.enums.DbankExceptionEnum;
import com.dean.demo.exception.DbankException;
import com.dean.demo.service.DreamPageService;
import com.dean.demo.service.MessageSender;
import com.dean.demo.service.ibmmq.IbmMqSendService;
import com.dean.demo.service.ibmmq.MqDemo;
import com.dean.demo.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2020/4/30 22:38
 */
@RestController
@RequestMapping("/dreamPage")
public class DreamPageController {
    @Autowired
    private DreamPageService dreamPageService;

    @Autowired
    private MessageSender messageSender;

    @RequestMapping(value = "/queryRecordListByPage",method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> queryRecordListByPage(@RequestParam Map<String,String> params){
        Map<String, Object> respMap = new HashMap<>();
        List<Map<String,Object>> recordList = dreamPageService.queryRecordListByPage(params);
        respMap.put("recordList",recordList);
        respMap.put("STATUS","1");
        respMap.put("MSG","成功");
        return ResponseEntity.ok(respMap);
    }

    /**
     * 修改任务状态队列测试-传统方式
     * @return
     */
    @RequestMapping(value = "/changeDreamTaskStatus",method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> changeDreamTaskStatus(){
        Map<String,Object> respMap = new HashMap<>();
        respMap.put("api_id","changeDreamTaskStatus");
        respMap.put("task_id","ZX202005030001");
        respMap.put("idNo","420682199908276310");
        respMap.put("timestamp",System.currentTimeMillis());
        respMap.put("value",200);
        String result = JsonUtils.toString(respMap);
        try {
            System.out.println("changeDreamTaskStatus放入队列的消息："+result);
            MqDemo.sendMessageToMq(result);
        }catch (Exception e){
            e.printStackTrace();
            throw new DbankException(DbankExceptionEnum.INVALID_PARAM_ERROR);
        }
        return ResponseEntity.ok(respMap);
    }

    /**
     * 修改任务状态队列测试-jms+spring+ibmMq
     * @return
     */
    @RequestMapping(value = "/changeStatus",method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> changeStatus(){
        Map<String,Object> respMap = new HashMap<>();
        respMap.put("api_id","changeStatus");
        respMap.put("task_id","ZX202005030001");
        respMap.put("idNo","420682199908276310");
        respMap.put("timestamp",System.currentTimeMillis());
        respMap.put("value",200);
        String result = JsonUtils.toString(respMap);
        try {
            System.out.println("changeStatus放入队列的消息："+result);
            messageSender.sendMessage(result);
        }catch (Exception e){
            e.printStackTrace();
            throw new DbankException(DbankExceptionEnum.INVALID_PARAM_ERROR);
        }
        return ResponseEntity.ok(respMap);
    }
}
