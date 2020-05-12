package com.dean.demo.enums;

/**
 * @author Dean.h
 * @version 1.0 2020/5/10
 */
public enum  DreamPageEnum {
    /*请求大数据结果码*/
    DREAM_RESULT_SUCC(0, "成功"),
    DREAM_RESULT_ERR(-1, "失败"),
    DREAM_INVALID_USER(1001, "查询梦想值客户不存在"),
    DREAM_INVALID_PARAM(1002, "缺少必填参数"),
    DREAM_ACCT_TYPE_ERROR(1010, "梦想账号类型错误"),
    DREAM_VALUE_INSUFFICIENT(1020, "客户梦想值不足，扣减失败"),
    DREAM_TRANS_REPEAT(1030, "已处理完成，请不要重复请求");


    private int status;
    private String statusMsg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    DreamPageEnum() {
    }

    DreamPageEnum(int status, String statusMsg) {
        this.status = status;
        this.statusMsg = statusMsg;
    }
}
