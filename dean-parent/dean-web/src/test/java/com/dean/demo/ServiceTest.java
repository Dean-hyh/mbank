package com.dean.demo;

import com.dean.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/19 13:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext-*.xml"})
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void serviceTest() {
        Boolean exit = userService.isExit("cf0015d3-bcdd-433b-889d-808b53b72640");
        System.out.println("#############################");
        System.out.println(exit);
        System.out.println("#############################");
    }

    @Test
    public void plusI(){
        int i = 1;
        int j = ++i + i++ + ++i + ++i + i++;
        System.out.println(i +"---" +j);
    }
}
