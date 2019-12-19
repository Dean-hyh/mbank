package com.ms.credit;

import com.ms.credit.utils.LocalFileUtils;
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
}

