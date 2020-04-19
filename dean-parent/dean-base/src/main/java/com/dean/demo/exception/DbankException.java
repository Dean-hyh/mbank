package com.dean.demo.exception;

import com.dean.demo.enums.DbankExceptionEnum;

/**
 * @version 1.0
 * @Author Dean
 * @Date 2019/7/26 9:31
 * 自定义异常类
 */
public class DbankException extends RuntimeException{
    private int status;

    /**
     * 参数：自定义异常枚举
     * @param dbankExceptionEnum
     */
    public DbankException(DbankExceptionEnum dbankExceptionEnum) {
        super(dbankExceptionEnum.getMessage());
        this.status = dbankExceptionEnum.getStatus();
    }

    /**
     * @param dbankExceptionEnum
     * @param cause
     */
    public DbankException(DbankExceptionEnum dbankExceptionEnum, Throwable cause) {
        super(dbankExceptionEnum.getMessage(), cause);
        this.status = dbankExceptionEnum.getStatus();
    }

    /**
     * 参数：接收自定义异常信息
     * @param message
     * @param cause
     * @param status
     */
    public DbankException(String message, Throwable cause, int status) {
        super(message, cause);
        this.status = status;
    }

    /**
     * 参数：接收自定义异常信息
     * @param message
     * @param status
     */
    public DbankException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
