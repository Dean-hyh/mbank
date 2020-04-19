package com.dean.demo;

import com.dean.demo.utils.LocalFileUtils;
import org.junit.Test;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/28 14:14
 */

public class POITest{
    @Test
    public void utilTest(){
        String extensionName = LocalFileUtils.getExtensionName("hahaah.txt");
        System.out.println(extensionName);
    }

    /*获取项目的相对路径*/
    @Test
    public void getPath(){
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(path);
    }
}

