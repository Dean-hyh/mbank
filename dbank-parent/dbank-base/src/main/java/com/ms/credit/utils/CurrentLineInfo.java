package com.ms.credit.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther Dean
 * @Date 2019-10-28  15:05:21
 * 获取当前线程所执行的代码的位置
 */
public class CurrentLineInfo {
    private static int originStackIndex = 2;

    /**
     * 获取当前时间
     * @return
     */
    public static String getTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 获取class文件名   eg:CurrentLineInfo.java
     * @return xxx.java
     */
    public static String getFileName() {
        return Thread.currentThread().getStackTrace()[originStackIndex].getFileName();
    }

    /**
     * 获取class全限定名    eg:com.ms.credit.utils.CurrentLineInfo
     * @return xx.xx.xx.xx
     */
    public static String getClassName() {
        return Thread.currentThread().getStackTrace()[originStackIndex].getClassName();
    }

    /**
     * 获取方法名  eg：getMethodName
     * @return  xxxx
     */
    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[originStackIndex].getMethodName();
    }

    /**
     * 获取行号
     * @return  37行
     */
    public static int getLineNumber() {
        return Thread.currentThread().getStackTrace()[originStackIndex].getLineNumber();
    }

    /**
     * 自定义拼接路径
     * @return  xx.xx.xx.xx\xxxx\45
     */
    public static String getFileAddress(){
        return  CurrentLineInfo.getTime()+" "+
                Thread.currentThread().getStackTrace()[originStackIndex].getClassName()+"."+
                Thread.currentThread().getStackTrace()[originStackIndex].getMethodName()+" "+"第"+
                Thread.currentThread().getStackTrace()[originStackIndex].getLineNumber()+"行";
    }
}