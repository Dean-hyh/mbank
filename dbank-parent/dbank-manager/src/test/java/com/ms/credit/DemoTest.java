package com.ms.credit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

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
}
