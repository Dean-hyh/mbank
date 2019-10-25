package com.ms.credit.pojo;

import java.io.Serializable;
import java.util.Date;

public class UserRole extends UserRoleKey implements Serializable {
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}