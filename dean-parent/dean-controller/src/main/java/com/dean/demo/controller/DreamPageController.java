package com.dean.demo.controller;

import com.dean.demo.enums.DbankExceptionEnum;
import com.dean.demo.exception.DbankException;
import com.dean.demo.service.DreamPageService;
import com.dean.demo.service.MessageSender;
import com.dean.demo.service.ibmmq.MqService;
import com.dean.demo.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private final Logger logger = LoggerFactory.getLogger(getClass());

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

    @RequestMapping(value = "/queryRecordListByPageV2",method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> queryRecordListByPageV2(@RequestParam Map<String,String> params){
        Map<String, Object> respMap = new HashMap<>();
        Map<String,Object> recordList = dreamPageService.queryRecordListByPageV2(params);
        respMap.put("recordList",recordList);
        respMap.put("STATUS","1");
        respMap.put("MSG","成功");
        return ResponseEntity.ok(respMap);
    }

    /**
     * 修改任务状态队列测试-传统方式
     * @return
     */
    @RequestMapping(value = "/changeDreamTaskStatus",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> changeDreamTaskStatus(){
        Map<String,Object> respMap = new HashMap<>();
        respMap.put("api_id","changeDreamTaskStatus");
        respMap.put("task_id","ZX202005030001");
        respMap.put("idNo","420682199908276310");
        respMap.put("timestamp",System.currentTimeMillis());
        respMap.put("value",200);
        String result = JsonUtils.toString(respMap);
        logger.info("changeDreamTaskStatus放入队列的消息："+result);
            boolean flag = MqService.sendMessageToMq(result,1);
            if(flag){
                logger.info("changeDreamTaskStatus消息发送成功："+result);
            }else {
                logger.error("任务消息发送失败");
                throw new DbankException(DbankExceptionEnum.MQ_MESSAGE_SEND_ERR);
            }
        return ResponseEntity.ok(respMap);
    }

    /**
     * 修改任务状态队列测试-jms+spring+ibmMq
     * @return
     */
    @RequestMapping(value = "/changeDreamTaskStatusV2",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> changeStatus(){
        Map<String,Object> respMap = new HashMap<>();
        respMap.put("api_id","changeStatus");
        respMap.put("task_id","ZX202005030001");
        respMap.put("idNo","420682199908276310");
        respMap.put("timestamp",System.currentTimeMillis());
        respMap.put("value",200);
        String result = JsonUtils.toString(respMap);
        logger.info("changeDreamTaskStatusV2放入队列的消息："+result);
        try {
            logger.debug("start======" + System.currentTimeMillis());
            messageSender.sendMessage(result);
            logger.info("changeStatus消息发送成功："+result);
        }catch (Exception e){
            logger.debug("start======" + System.currentTimeMillis());

            e.printStackTrace();
            logger.error("任务消息发送异常{}",e);
            throw new DbankException(DbankExceptionEnum.MQ_MESSAGE_SEND_ERR);
        }
        return ResponseEntity.ok(respMap);

    }
}
