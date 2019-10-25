package com.ms.credit.demo;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/26 14:17
 */
public class Demo_CreateStr {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hel" + new String("lo");
        System.out.println(str1 == str2);
    }
}
