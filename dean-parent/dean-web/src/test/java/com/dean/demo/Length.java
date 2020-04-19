package com.dean.demo;

import com.dean.demo.constants.BaseUserId;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/10/31 10:44
 */
public class Length {
    @Test
    public void lengthTest() {
        String str = "qwdcnksjaa";
        System.out.println(str.length());

        String[] arr = {"1", "2"};
        System.out.println(arr.length);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(list.size());
    }

    @Test
    public void lenTest() {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }

    @Test
    public void arrLen() {
        String[] arr = {null, "1"};
    }

    @Test
    public void removeIndex(){
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        System.out.println(arrayList);
        arrayList.remove(1);
        System.out.println(arrayList);

    }

    @Test
    public void myTest(){
        System.out.println(BaseUserId.LoginType.F.name());
    }
}
