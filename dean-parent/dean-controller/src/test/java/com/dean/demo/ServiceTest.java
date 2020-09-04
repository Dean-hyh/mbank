package com.dean.demo;

import com.dean.demo.pojo.VO.UserVO;
import com.dean.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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

    @Test
    public void test1(){
        //UserVO userVO = userService.queryUserById("002108e2-9a10-4510-9683-8d8fd1d374ef");
        System.out.println("你好");

    }

    @Test
    public void test2(){
        List<String> strings = userService.selectUserListByDeptId("999");
        if(strings.contains("12")){
            System.out.println(true);
        }
        System.out.println("false");
    }
}
