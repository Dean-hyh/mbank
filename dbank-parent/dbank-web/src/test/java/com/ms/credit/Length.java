package com.ms.credit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/10/31 10:44
 */
public class Length {
    @Test
    public void lengthTest(){
        String str = "qwdcnksjaa";
        System.out.println(str.length());

        String[] arr = {"1","2"};
        System.out.println(arr.length);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(list.size());
    }
}
