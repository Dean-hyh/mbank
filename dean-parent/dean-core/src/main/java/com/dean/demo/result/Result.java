package com.dean.demo.result;

import java.io.Serializable;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/18 15:33
 * 结果通知类
 */
public class Result implements Serializable {
    //判断该变量
    private boolean succ;
    //返回的字符串
    private String msg;

    public Result() {
    }

    public Result(boolean succ, String msg) {
        this.succ = succ;
        this.msg = msg;
    }

    public boolean isSucc() {
        return succ;
    }

    public void setSucc(boolean succ) {
        this.succ = succ;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
