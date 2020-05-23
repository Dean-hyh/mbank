package com.dean.demo.constants;

/**
 * @author Dean.h
 * @version 1.0 2020/5/11
 */
public abstract class DreamPageConstans {
    public static final String SUCC_TAGS = "200";
    public static final String ERR_TAGS = "5--";
    public static final String repeat_request = "1030";
    public static final int err_status = 1;
    public static final int succ_status = 0;
    public static final int status_null = 2;

    public static final int DREAMPAGE_MQMSG_STATUS= 0 ; //mq数据入队失败后入库  0-未处理（入库初始状态） 1-已处理
}
