package com.ms.credit.result;

import java.io.Serializable;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/27 16:19
 */
public class ErrorMsg implements Serializable {
    private Integer errCode;
    private String msg;

    public ErrorMsg(Integer errCode, String msg) {
        this.errCode = errCode;
        this.msg = msg;
    }

    public ErrorMsg() {
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
