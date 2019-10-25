package com.ms.credit.pojo.DO;

import java.io.Serializable;

public class PermFuncKey implements Serializable {
    private String permId;

    private String funcName;

    private static final long serialVersionUID = 1L;

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId == null ? null : permId.trim();
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName == null ? null : funcName.trim();
    }
}