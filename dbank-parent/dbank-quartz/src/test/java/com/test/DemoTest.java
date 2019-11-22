package com.test;

import com.ms.credit.quartz.service.AutoJobDemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/22 17:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext-quartz.xml")
public class DemoTest {

    @Autowired
    private AutoJobDemoService autoJobDemoService;
    @Test
    public void Test(){
        autoJobDemoService.execute("20191122");
    }
}
