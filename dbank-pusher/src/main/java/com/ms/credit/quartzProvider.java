package com.ms.credit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class quartzProvider {

    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext app = new  ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");

        app.start();

        System.in.read();  //阻断当前线程   卡住不继续执行    回车就开始执行了

    }
}