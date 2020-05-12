package com.dean.demo;

import com.dean.demo.service.utils.DreamResultParseUtil;
import com.dean.demo.utils.LocalObjectUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author Dean
 * @version 1.0
 * @date 2019/12/18 10:54
 */
public class BeanTest {
    @Test
    public void isEmpty(){
        Stu stu = new Stu();
        boolean b = LocalObjectUtils.allFieldIsNull(stu);
        System.out.println(b);
        System.out.println(stu.toString());
        System.out.println(String.valueOf(stu));
        System.out.println(StringUtils.isNotBlank(stu.toString()));

        boolean empty = StringUtils.isEmpty("");
        System.out.println(empty);
    }

    @Test
    public void isNull(){
        try {
            Class<?>[] interfaces = null;
            System.out.println(interfaces.length);
        }catch (Exception e){
            System.out.print("出现异常啦,异常原因：");
            if("NullPointerException".equals(e.toString().substring(e.toString().lastIndexOf(".",e.toString().length())+1))){
                System.out.println("空指针");
            }
        }
    }

    @Test
    public void dateTest() throws ParseException {
        String dateStr = "20200511";
        Date parse = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
        String format = new SimpleDateFormat("yyyy/MM/dd").format(parse);
        System.out.println(format);
    }

    @Test
    public void jsonTest() throws ParseException {
        Map<String,Object> reMap = new HashMap<>();
        Map<String,Object> resultMap = new HashMap<>();
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("date","20200504");
        map1.put("time","12110101");
        map1.put("desc","充话费");
        map1.put("value","100");
        map1.put("serNo","1001");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("date","20200508");
        map2.put("time","12110101");
        map2.put("desc","签到");
        map2.put("value","100");
        map2.put("serNo","1002");
        Map<String,Object> map3 = new HashMap<>();
        map3.put("date","20200511");
        map3.put("time","12110101");
        map3.put("desc","兑换");
        map3.put("value","-300");
        map3.put("serNo","1003");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        resultMap.put("list",list);
        resultMap.put("dreamValueNo","123123113122414514");
        reMap.put("result",resultMap);
        reMap.put("status",1010);
        //reMap.put("statuMsg","成功");

        System.out.println(reMap);
        String jsonSrt = JSONObject.fromObject(reMap).toString();
        System.out.println("=============================");
        System.out.println(jsonSrt);
        Map<String, Object> map = DreamResultParseUtil.jsonStrToMap(jsonSrt);
        System.out.println("=============================");
        System.out.println(map);
        System.out.println("=============================");
        List<Map<String, Object>> recordList = DreamResultParseUtil.getList(jsonSrt);
        System.out.println(recordList);

        System.out.println("获取梦想记录列表失败："+DreamResultParseUtil.getCodeAndMsg(jsonSrt));
    }

}
