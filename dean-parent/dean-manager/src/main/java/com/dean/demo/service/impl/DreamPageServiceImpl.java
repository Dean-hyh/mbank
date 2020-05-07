package com.dean.demo.service.impl;

import com.dean.demo.service.DreamPageService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Dean
 * @version 1.0
 * @date 2020/4/30 22:50
 */
@Service
public class DreamPageServiceImpl implements DreamPageService {
    @Override
    public List<Map<String, Object>> queryRecordListByPage(Map<String, String> params) {
        List<Map<String,Object>> recordList = new ArrayList<>();
        String[] descs = {"完成爱用卡","完成扫码付","完成乐登录","兑换","完成打卡","完成充话费","办理亲情卡","签到"};
        String[] value = {"100","200","200","500","50","120","100","20"};
        String[] sign = {"0","0","0","1","0","0","0","0"};

        int startRow = 34;//33条数据
        if(params.get("lastNo")!=null){
            startRow = Integer.parseInt(params.get("lastNo"));
            if(startRow>33){
                startRow = 33;
            }
        }
        int pageSize = Integer.parseInt(params.get("size"));

        for (int i = 0; i <pageSize ; i++) {
            Map<String, Object> resultMap = new HashMap<>();
            int index = new Random().nextInt(8);
            startRow--;
            if(startRow<1){
                return recordList;
            }
            resultMap.put("date","2020/05/04");
            resultMap.put("time","15232621");
            resultMap.put("sign",sign[index]);
            resultMap.put("transDecs",descs[index]);
            resultMap.put("dreamValue",value[index]);
            resultMap.put("flowNo",startRow);
            recordList.add(resultMap);
        }
        return recordList;
    }
}
