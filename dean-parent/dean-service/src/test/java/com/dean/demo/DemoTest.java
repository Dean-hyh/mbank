package com.dean.demo;

import com.dean.demo.utils.JsonUtils;
import lombok.val;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/10/29 17:16
 */
public class DemoTest {
    @Value("#{propertiesReader.workerId}")
    public long workerId;

    @Test
    public void demo() {
        System.out.println(workerId);
    }

    @Test
    public void demo2() {
        String str = "houyuanhui";
        String trim = str.trim();
        System.out.println(str + str.length());
        char[] chars = str.toCharArray();
        System.out.println(chars.length);
        System.out.println(chars[0]);
        System.out.println(Arrays.toString(chars));
        System.out.println(trim + trim.length());
        char[] chars1 = trim.toCharArray();
        System.out.println(Arrays.toString(chars1));
        System.out.println("-----------------------");
        String str2 = " ";
        System.out.println(str2.length());
        boolean empty = StringUtils.isEmpty(str2);
        System.out.println(empty);
    }

    @Test
    public void demo3(){
        Map<String,Object> reMap = new HashMap<>();
        Map<String,Object> result = new HashMap<>();
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        map1.put("date","20200504");
        map1.put("time","12110101");
        map1.put("desc","折扣");
        map1.put("value","10");
        map1.put("serNo","1001");
        list.add(map1);
        map2.put("date","20200506");
        map2.put("time","14180121");
        map2.put("desc","支付");
        map2.put("value","10");
        map2.put("serNo","1002");
        list.add(map2);
        result.put("crdtNo","620522199102012804");
        result.put("customerNo","620522199102012804");
        result.put("dreamValuNo","20200428100100235");
        result.put("list",list);
        reMap.put("status",0);
        reMap.put("msg","成功");
        reMap.put("result",result);
        String res = JsonUtils.toString(reMap);
        System.out.println(res);
        System.out.println("==================1");
        Map<String,Object> respMap = JsonUtils.toMap(res, String.class, Object.class);
        String status = String.valueOf(respMap.get("status"));
        if(status.equals("0")){
            Map result1 = (Map)respMap.get("result");
            System.out.println(result1);
            System.out.println("==================2");
            Object list1 = result1.get("list");
            System.out.println(JsonUtils.toString(list1));
            System.out.println("==================3");
            Object list2 = ((Map) respMap.get("result")).get("list");
            System.out.println(list2);
        }else{
            System.out.println("查询失败");
            System.out.println("errCode:["+status+"]");
        }
    }

    @Test
    public void test3(){
        Map<String, Object> map = new HashMap<>();
        map.put("he",1);
       if(map.get("he")==null){
           System.out.println("cuowu");
       }
       int he = (int)map.get("he");
        System.out.println(he);
    }

    @Test
    public void test4(){
        final long l = System.currentTimeMillis();
        Date date = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmssss");
        final String format = dateFormat.format(date);
        System.out.println(format);
    }


    @Test
    public void test5(){
        System.out.println(2068-1918);
    }

    public static void main(String[] args) {
        String click_url = "www.baidu.com/wsv2?enstr=asjdacahaioshfaohsfoia";
        String click_url2 = "www.baidu.com/wsv2?tpenstr=asjdacahaioshfaohsfoia";
        String bizChannel="";
        if(click_url.contains("bizChannel")){
            bizChannel = click_url.substring(click_url.lastIndexOf("=")+1,click_url.length());
            click_url=click_url.substring(0,click_url.indexOf("bizChannel")-1);
        }else {
            bizChannel = "ZY-CLQM1";
        }
        String lastChar = click_url.substring(click_url.length()-1);
        if(!"/".equals(lastChar)){
            click_url=click_url+"/";
        }
        System.out.println(bizChannel + "------" +click_url);
    }

    @Test
    public void test6(){
        String click_url2 = "www.baidu.com/wsv2?tpenstr=asjdacahaioshfaohsfoia&ccapp_channel=WX";
        
    }
}
