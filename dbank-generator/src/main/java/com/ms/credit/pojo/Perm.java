package com.ms.credit.pojo;

import java.io.Serializable;
import java.util.Date;

public class Perm implements Serializable {
    private String permId;

    private String permName;

    private String description;

    private String parentPermId;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId == null ? null : permId.trim();
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName == null ? null : permName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getParentPermId() {
        return parentPermId;
    }

    public void setParentPermId(String parentPermId) {
        this.parentPermId = parentPermId == null ? null : parentPermId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}