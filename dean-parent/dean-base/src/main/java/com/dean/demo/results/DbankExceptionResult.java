package com.dean.demo.results;

import com.dean.demo.exception.DbankException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @Author Dean
 * @Date 2019/7/26 9:52
 * 自定义异常结果展示类
 */
public class DbankExceptionResult {

    private int status;
    private String message;
    private String timestamp;

    /**
     * 参数：自定的义异常类  LyException
     * @param dbankException
     */
    public DbankExceptionResult(DbankException dbankException) {
        this.status = dbankException.getStatus();
        this.message = dbankException.getMessage();
        this.timestamp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
