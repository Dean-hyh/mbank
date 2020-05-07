package com.dean.demo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dean
 * @version 1.0
 * @date 2020/4/27 18:39
 */
public class Dizhi {
    @Test
    public void test1(){
        String str1 = "老河口市公安局";
        String str2 = "湖北省故城县薛集镇韩营村九组24号";
        String str3 = "湖北省公安局";
        String str4 = "湖北省武汉市洪山区公安局";
        int index = str1.lastIndexOf("市公安局");
        str1 = str1.substring(0,str1.lastIndexOf("市公安局"));
        if(-1 == str2.lastIndexOf(str1)){
            System.out.println("户籍所在地与发证机关不一致");
        }else {
            System.out.println("一致");
        }
    }

    @Test
    public void test2(){
        long l = System.currentTimeMillis();
        System.out.println(l);
        Date dateTime = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = dateFormat.format(dateTime);
        System.out.println(date);
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        String time = timeFormat.format(dateTime);
        System.out.println(time);
    }
}
