package com.dean.demo.service;

import java.util.List;
import java.util.Map; /**
 * @author Dean
 * @version 1.0
 * @date 2020/4/30 22:49
 */
public interface DreamPageService {

    List<Map<String,Object>> queryRecordListByPage(Map<String, String> params);

    Map<String,Object> queryRecordListByPageV2(Map<String, String> params);

    void increaseDreamValue(String msgStr);
}
