package com.dean.demo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UrlTest {
    @Test
    public void test1(){
       //String click_url = "https://creditcard.cmbc.com.cn/wsv2/supplementcard/?enstr=MES0c0zEw0fWpEPkciJ0PFr4j2uYRHsxTbT5c6a%2ftJdlC6ejPn0EZl%2fKmaS%2bqBIbnvNmXpQwxNfjCLyKaplcBZcZtTa7qaTjsYVJD8AYNmwWIiGKIIYX2tptF1Kprki71bUdpyZ2VXiNJ11g4AQxphb8Qh95C9eU8aE9skIItFB4GSngBRunKjS8ktI9Lq6xnLpS58CtmIxo%2fCWMQQp7qTLbii8v9g1pPjv2%2bgDXZRdsGX9bSJ5m%2fr%2fNYuy4saVD0TYH95FmJjskQqvNNpPi2R6EpIKhY%2bDHbEVklKrWJWeXk9FiM%2bPb%2bwX%2bCMAk3TEfR2fytMXuZiCcal0NTpycZQ%3d%3d&ccapp_channel=APP";
       //String click_url = "https://creditcard.cmbc.com.cn/wsv2/supplementcard/?cid=1&uuid=sjahajncjaskhnaojhdsoaiio&enstr=MES0c0zEw0fWpEPkciJ0PFr4j2uYRHsxTbT5c6a%2ftJdlC6ejPn0EZl%2fKmaS%2bqBIbnvNmXpQwxNfjCLyKaplcBZcZtTa7qaTjsYVJD8AYNmwWIiGKIIYX2tptF1Kprki71bUdpyZ2VXiNJ11g4AQxphb8Qh95C9eU8aE9skIItFB4GSngBRunKjS8ktI9Lq6xnLpS58CtmIxo%2fCWMQQp7qTLbii8v9g1pPjv2%2bgDXZRdsGX9bSJ5m%2fr%2fNYuy4saVD0TYH95FmJjskQqvNNpPi2R6EpIKhY%2bDHbEVklKrWJWeXk9FiM%2bPb%2bwX%2bCMAk3TEfR2fytMXuZiCcal0NTpycZQ%3d%3d";
       String click_url = "https://creditcard.cmbc.com.cn/wsv2/supplementcard/";
       String clickUrlWithoutChannel="";
       String clickUrlWithoutParams="";
       //获取ccapp_channel
       if(click_url.contains("ccapp_channel")){
           clickUrlWithoutChannel = click_url.substring(0,click_url.lastIndexOf("ccapp_channel")-1);
       }else {
           clickUrlWithoutChannel=click_url;
       }
       //获取域名链接
        if(clickUrlWithoutChannel.contains("enstr")){
            if(clickUrlWithoutChannel.contains("tpenstr")){
                clickUrlWithoutParams=clickUrlWithoutChannel.substring(0,clickUrlWithoutChannel.lastIndexOf("tpenstr")-1);
            }else{
                clickUrlWithoutParams=clickUrlWithoutChannel.substring(0,clickUrlWithoutChannel.lastIndexOf("enstr")-1);
            }
        }else {
            clickUrlWithoutParams = clickUrlWithoutChannel;
        }
        System.out.println(clickUrlWithoutChannel);
        System.out.println(clickUrlWithoutParams);
        System.out.println("==========================================");
        //登录判断
        Boolean isLogin = true;
        if(!isLogin){
            System.out.println(clickUrlWithoutChannel);
            return;
        }

        //已登录
        if(clickUrlWithoutParams.contains("?")){
            System.out.println(clickUrlWithoutParams+"&tpenstr=hdjakdhwoiuahnsdaoiuhdfuahfwuaohcduaohuwo");
        }else {
            System.out.println(clickUrlWithoutParams+"?tpenstr=jadkldjajfhiaohcaionczsnajhfsaio");
        }
    }

    @Test
    public void test2(){
        //String click_url = "https://creditcard.cm bc.co m.cn/wsv2/supplementCard/?tpenstr=MES0c0zEw0fWpEPkciJ0PFr4j2uYRHsxTbT5c6a%2ftJdlC6ejPn0EZl%2fKmaS%2bqBIbnvNmXpQwxNfjCLyKaplcBZcZtTa7qaTjsYVJD8AYNmwWIiGKIIYX2tptF1Kprki71bUdpyZ2VXiNJ11g4AQxphb8Qh95C9eU8aE9skIItFB4GSngBRunKjS8ktI9Lq6xnLpS58CtmIxo%2fCWMQQp7qTLbii8v9g1pPjv2%2bgDXZRdsGX9bSJ5m%2fr%2fNYuy4saVD0TYH95FmJjskQqvNNpPi2R6EpIKhY%2bDHbEVklKrWJWeXk9FiM%2bPb%2bwX%2bCMAk3TEfR2fytMXuZiCcal0NTpycZQ%3d%3d&cardId=51&level=2&channelCode=WX";
        String click_url = "https://creditcard.cmbc.com.cn/wsv2/supplementcard/";
        //获取参数
        Map<String, String> reqParams = URLRequest(click_url);
        String bizChannel=reqParams.get("channelCode");
        String cardId=reqParams.get("cardId");
        String cardLevel=reqParams.get("level");
        String enstr = reqParams.get("tpenstr");
        System.out.println(bizChannel+"||"+cardId+"||"+cardLevel+"||"+enstr);
        System.out.println(UrlPage(click_url));
    }

    public Map<String, String> URLRequest(String URL){
        Map<String, String> mapRequest = new HashMap<>(32);
        String[] arrSplit=null;
        String strUrlParam=TruncateUrlPage(URL);
        if(StringUtils.isNotEmpty(strUrlParam)){
            //每个键值为一组 www.2cto.com
            arrSplit=strUrlParam.split("[&]");
            for(String strSplit:arrSplit) {
                String[] arrSplitEqual=null;
                arrSplitEqual= strSplit.split("[=]");
                //解析出键值
                if(arrSplitEqual.length>1) {
                    //正确解析
                    mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
                }else {
                    if(arrSplitEqual[0]!="") {
                        //只有参数没有值，放入空值
                        mapRequest.put(arrSplitEqual[0], "");
                    }
                }
            }
        }
        return mapRequest;
    }

    private String TruncateUrlPage(String strURL){
        String strAllParam=null;
        String[] arrSplit=null;
        strURL=strURL.trim();
        arrSplit=strURL.split("[?]");
        if(strURL.length()>1){
            if(arrSplit.length>1) {
                if(arrSplit[1]!=null) {
                    strAllParam=arrSplit[1];
                }
            }
        }
        return strAllParam;
    }

    public static String UrlPage(String strURL){
        String strPage=strURL;
        String[] arrSplit=null;
        strURL=strURL.trim();
        arrSplit=strURL.split("[?]");
        if(strURL.length()>0) {
            if(arrSplit.length>1){
                if(arrSplit[0]!=null){
                    strPage=arrSplit[0];
                }
            }
        }
        return strPage;
    }

    @Test
    public void test3(){
        //String click_url = "https://creditcard.cmbc.com.cn/wsv2/supplementcard/?tpenstr=MES0c0zEw0fWpEPkciJ0PFr4j2uYRHsxTbT5c6a%2ftJdlC6ejPn0EZl%2fKmaS%2bqBIbnvNmXpQwxNfjCLyKaplcBZcZtTa7qaTjsYVJD8AYNmwWIiGKIIYX2tptF1Kprki71bUdpyZ2VXiNJ11g4AQxphb8Qh95C9eU8aE9skIItFB4GSngBRunKjS8ktI9Lq6xnLpS58CtmIxo%2fCWMQQp7qTLbii8v9g1pPjv2%2bgDXZRdsGX9bSJ5m%2fr%2fNYuy4saVD0TYH95FmJjskQqvNNpPi2R6EpIKhY%2bDHbEVklKrWJWeXk9FiM%2bPb%2bwX%2bCMAk3TEfR2fytMXuZiCcal0NTpycZQ%3d%3d&channelCode=WX&cardId=51&level=2";
        //String click_url = "https://creditcard.cmbc.com.cn/wsv2/supplementcard/?tpenstr=MES0c0zEw0fWpEPkciJ0PFr4j2uYRHsxTbT5c6a%2ftJdlC6ejPn0EZl%2fKmaS%2bqBIbnvNmXpQwxNfjCLyKaplcBZcZtTa7qaTjsYVJD8AYNmwWIiGKIIYX2tptF1Kprki71bUdpyZ2VXiNJ11g4AQxphb8Qh95C9eU8aE9skIItFB4GSngBRunKjS8ktI9Lq6xnLpS58CtmIxo%2fCWMQQp7qTLbii8v9g1pPjv2%2bgDXZRdsGX9bSJ5m%2fr%2fNYuy4saVD0TYH95FmJjskQqvNNpPi2R6EpIKhY%2bDHbEVklKrWJWeXk9FiM%2bPb%2bwX%2bCMAk3TEfR2fytMXuZiCcal0NTpycZQ%3d%3d&cardId=51&level=2";
        String click_url = "https://creditcard.cmbc.com.cn/wsv2/supplementcard/";
        String urlWithoutUserDefParams="";
        if(click_url.contains("channelCode")) {
            urlWithoutUserDefParams = click_url.substring(0, click_url.lastIndexOf("channelCode") - 1);
        }else {
            urlWithoutUserDefParams=click_url;
        }
        System.out.println(urlWithoutUserDefParams);
    }

    @Test
    public void test4(){
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        String a = stringStringHashMap.get("a");
        System.out.println(a);
    }

    @Test
    public void test5(){
        long l = System.currentTimeMillis();
        System.out.println(l);
    }
}
