package com.dean.demo.quartz.listener;

import org.quartz.ee.servlet.QuartzInitializerListener;

import javax.servlet.ServletContextEvent;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/25 17:42
 */
public class QuartzListenner extends QuartzInitializerListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);
    }
}
