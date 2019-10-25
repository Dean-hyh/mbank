package com.ms.credit.pojo.DO;

import java.io.Serializable;
import java.util.Date;

public class Org implements Serializable {
    private String orgId;

    private String parentOrgId;

    private String realOrgId;

    private String realLevel;

    private String name;

    private String shortName;

    private String address;

    private String creatorId;

    private Date createTime;

    private Date updateTime;

    private String status;

    private Date sysSyncTime;

    private static final long serialVersionUID = 1L;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId == null ? null : parentOrgId.trim();
    }

    public String getRealOrgId() {
        return realOrgId;
    }

    public void setRealOrgId(String realOrgId) {
        this.realOrgId = realOrgId == null ? null : realOrgId.trim();
    }

    public String getRealLevel() {
        return realLevel;
    }

    public void setRealLevel(String realLevel) {
        this.realLevel = realLevel == null ? null : realLevel.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getSysSyncTime() {
        return sysSyncTime;
    }

    public void setSysSyncTime(Date sysSyncTime) {
        this.sysSyncTime = sysSyncTime;
    }
}