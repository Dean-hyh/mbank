package com.ms.credit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.util.Arrays;

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
}
