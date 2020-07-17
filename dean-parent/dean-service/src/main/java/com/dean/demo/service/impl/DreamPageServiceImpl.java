package com.dean.demo.service.impl;

import com.dean.demo.constants.DreamPageConstans;
import com.dean.demo.enums.DbankExceptionEnum;
import com.dean.demo.enums.DreamPageEnum;
import com.dean.demo.exception.DbankException;
import com.dean.demo.service.DreamPageService;
import com.dean.demo.service.utils.DreamResultParseUtil;
import com.dean.demo.utils.JsonUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.*;

/**
 * @author Dean
 * @version 1.0
 * @date 2020/4/30 22:50
 */
@Service
public class DreamPageServiceImpl implements DreamPageService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<Map<String, Object>> queryRecordListByPage(Map<String, String> params) {
        List<Map<String,Object>> recordList = new ArrayList<>();
        Map<String, Object> respMap = new HashMap<>();
        Map<String, Object> respTestMap = new HashMap<>();
        String[] descs = {"完成爱用卡","完成扫码付","完成乐登录","兑换","完成打卡","完成充话费","办理亲情卡","签到"};
        String[] value = {"100","200","200","-500","50","120","100","20"};
        int[] reStatus = {0,-1,1001,1002,1010,1020,1030};
        // [0,6]
        final int testIndex = 0;
        //33条数据
        int startRow = 34;
        if(params.get("lastNo")!=null){
            startRow = Integer.parseInt(params.get("lastNo"));
            if(startRow>33){
                startRow = 33;
            }
        }
        int pageSize = Integer.parseInt(params.get("size"));
        for (int i = 0; i <pageSize ; i++) {
            Map<String, Object> reMap = new HashMap<>();
            int index = new Random().nextInt(8);
            startRow--;
            if(startRow<1){
                return recordList;
            }
            reMap.put("date","20200511");
            reMap.put("time","15232621");
            reMap.put("transDecs",descs[index]);
            reMap.put("dreamValue",value[index]);
            reMap.put("flowNo",startRow);
            recordList.add(reMap);
        }
        respMap.put("list",recordList);
        respMap.put("dreamValueNo","20200428100100235");
        respTestMap.put("status",reStatus[testIndex]);
        respTestMap.put("result",respMap);
        if((int)respTestMap.get("status") == DreamPageConstans.succ_status){
            try {
                recordList = DreamResultParseUtil.getList(respTestMap);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            //判断异常类型
            String codeAndMsg = "";
            try {
                codeAndMsg = DreamResultParseUtil.getCodeAndMsg(respTestMap);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            logger.error("获取梦想记录列表失败：{}",codeAndMsg);
            throw new DbankException(DbankExceptionEnum.FILE_CONTENT_IS_EMPTY);
        }
        //与大数据联调前，前端交互测试数据========^^^^^^
        return recordList;
    }

    @Override
    public Map<String, Object> queryRecordListByPageV2(Map<String, String> params) {
        Map<String, Object> reMap = new HashMap<>();
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> resultStatistics = new HashMap<>();
        Map<String, Object> respTestMap = new HashMap<>();
        String[] descs = {"完成爱用卡","完成扫码付","完成乐登录","兑换","完成打卡","完成充话费","办理亲情卡","签到"};
        String[] value = {"100","200","200","-500","50","120","100","20"};
        int[] reStatus = {0,-1,1001,1002,1010,1020,1030};
        // [0,6]
        final int testIndex = 0;
        if(StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("size"))){
            throw new DbankException(DbankExceptionEnum.INVALID_PARAM_ERROR);
        }
        int page = Integer.parseInt(params.get("page"));
        int size = Integer.parseInt(params.get("size"));
        int startRow = (page-1)*size + 1;//1,21,41,61
        int total = startRow + size;//21,41,61,81
        if(total<42) {
            for (int i = startRow; i < total; i++) {
                Map<String, Object> respMap = new HashMap<>();
                int index = new Random().nextInt(8);
                int count = 1;
                count++;
                respMap.put("tx_date", "20200520");
                respMap.put("tx_time", "15232621");
                respMap.put("tx_desc", descs[index]);
                respMap.put("dream_val", value[index]);
                respMap.put("flow_no", count);
                respMap.put("dreamValueNo", "20200428100100235");
                list.add(respMap);
            }
            resultStatistics.put("totalSize", "42");
            respTestMap.put("status", "200");
            respTestMap.put("statusMsg", "200");
            respTestMap.put("result", list);
            respTestMap.put("resultStatistics", resultStatistics);
        }else {
            return respTestMap;
        }
        //结果处理
        if(respTestMap.get("status").equals(DreamPageConstans.SUCC_TAGS)){
            try {
                reMap = DreamResultParseUtil.getMap(respTestMap);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            //判断异常类型
            String codeAndMsg = "";
            try {
                codeAndMsg = DreamResultParseUtil.getCodeAndMsg(respTestMap);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            logger.error("获取梦想记录列表失败：{}",codeAndMsg);
            throw new DbankException(DbankExceptionEnum.FILE_CONTENT_IS_EMPTY);
        }
        return reMap;
    }

    @Override
    public void increaseDreamValue(String msgStr) {
        Map<String, String> mqReceiveMap = JsonUtils.toMap(msgStr, String.class, String.class);
        if(MapUtils.isNotEmpty(mqReceiveMap)){
            String taskId = mqReceiveMap.get("task_id");
            logger.info("完成任务：" + taskId);
        }
    }
}
