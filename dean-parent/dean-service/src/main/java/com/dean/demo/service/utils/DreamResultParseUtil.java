package com.dean.demo.service.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 梦想页大数据响应结果处理工具
 * @author yuanh
 * @version 1.0 2020/5/11
 */
@SuppressWarnings("all")
public class DreamResultParseUtil {

    private static final Logger logger = LoggerFactory.getLogger(DreamResultParseUtil.class);

    private static final Map<String,String> codeMap = new HashMap<>();

    static {
        codeMap.put("0","成功");
        codeMap.put("-1","失败");
        codeMap.put("1001","查询梦想值客户不存在");
        codeMap.put("1002","缺少必要参数");
        codeMap.put("1010","梦想账号类型错误");
        codeMap.put("1020","梦想值不足，扣减失败");
        codeMap.put("1030","已处理完成，请不要重复提请求");
    }

    /**
     * 将json字符串转换为map集合并格式化日期
     * @param resource
     * @return
     * @throws ParseException
     */
    public static Map<String,Object> jsonStrToMap(Object resource) throws ParseException {
        List<Map<String,Object>> recordList = new ArrayList<>();
        JSONObject jsonObject = JSONObject.fromObject(resource);
        if(jsonObject.containsKey("result")){
            JSONObject result = jsonObject.getJSONObject("result");
            if(result.containsKey("list")){
                JSONArray list = result.getJSONArray("list");
                for (Object map : list) {
                    JSONObject jsonMap = JSONObject.fromObject(map);
                    if(jsonMap.containsKey("date")){
                        String dateStr = jsonMap.getString("date");
                        Date parse = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
                        String formatDate = new SimpleDateFormat("yyyy/MM/dd").format(parse);
                        jsonMap.put("date",formatDate);
                    }
                    recordList.add(jsonMap);
                }
                result.put("list",recordList);
            }
            jsonObject.put("result",result);
        }
        return jsonObject;
    }

    /**
     * 获取结果中的List
     * @param resource
     * @return
     * @throws ParseException
     */
    public static List<Map<String,Object>> getList(Object resource) throws ParseException {
        List<Map<String,Object>> recordList = new ArrayList<>();
        JSONObject jsonObject = JSONObject.fromObject(resource);
        if (jsonObject.containsKey("result")) {
            JSONObject result = jsonObject.getJSONObject("result");
            if (result.containsKey("list")) {
                JSONArray list = result.getJSONArray("list");
                for (Object map : list) {
                    JSONObject jsonMap = JSONObject.fromObject(map);
                    if (jsonMap.containsKey("date")) {
                        String dateStr = jsonMap.getString("date");
                        Date parse = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
                        String formatDate = new SimpleDateFormat("yyyy/MM/dd").format(parse);
                        jsonMap.put("date", formatDate);
                    }
                    recordList.add(jsonMap);
                }
            }
        }
        return recordList;
    }

    /**
     * 获取结果中的List
     * @param resource
     * @return
     * @throws ParseException
     */
    public static Map<String,Object> getMap(Object resource) throws ParseException {
        List<Map<String,Object>> recordList = new ArrayList<>();
        Map<String,Object> reMap = new HashMap<>();
        JSONObject jsonObject = JSONObject.fromObject(resource);
        if (jsonObject.containsKey("result")) {
            JSONArray resultList = jsonObject.getJSONArray("result");
                for (Object map : resultList) {
                    JSONObject jsonMap = JSONObject.fromObject(map);
                    Map<String, Object> map1 = new HashMap<>();
                    if (jsonMap.containsKey("tx_date")) {
                        String dateStr = jsonMap.getString("tx_date");
                        Date parse = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
                        String formatDate = new SimpleDateFormat("yyyy/MM/dd").format(parse);
                        map1.put("date", formatDate);
                    }
                    if (jsonMap.containsKey("tx_time")) {
                        String timeStr = jsonMap.getString("tx_time");
                        map1.put("time", timeStr);
                    }
                    if (jsonMap.containsKey("tx_sep_no")) {
                        String dateStr = jsonMap.getString("tx_sep_no");
                        map1.put("transNo", dateStr);
                    }
                    if (jsonMap.containsKey("dream_val")) {
                        String dateStr = jsonMap.getString("dream_val");
                        map1.put("dreamvalue", dateStr);
                    }
                    if (jsonMap.containsKey("tx_desc")) {
                        String dateStr = jsonMap.getString("tx_desc");
                        map1.put("transDesc", dateStr);
                    }
                    if (jsonMap.containsKey("flow_no")) {
                        String dateStr = jsonMap.getString("flow_no");
                        map1.put("flowNo", dateStr);
                    }
                    recordList.add(map1);
                }
        }

        reMap.put("recordList",recordList);
        if (jsonObject.containsKey("resultStatistics")) {
            JSONObject resultStatistics = jsonObject.getJSONObject("resultStatistics");
            if(resultStatistics.containsKey("totalSize")){
                String totalSize = resultStatistics.getString("totalSize");
                reMap.put("totalSize",totalSize);
            }
        }
        return reMap;
    }

    /**
     * 获取异常信息
     * @param resource
     * @return
     * @throws ParseException
     */
    public static String getCodeAndMsg(Object resource) throws ParseException {
        JSONObject jsonObject = JSONObject.fromObject(resource);
        if(jsonObject.containsKey("status")){
            String status = jsonObject.getString("status");
            return status;
        }
        return null;
    }
}
