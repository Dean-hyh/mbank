package com.ms.credit.demo;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/27 15:43
 */
public class Demo_SplitStr {
    public static void main(String[] args) {
        String str = "a|b|c";
        String[] split = str.split("\\|");
        for (String s : split) {
            System.out.println(s);
        }

    }
}
