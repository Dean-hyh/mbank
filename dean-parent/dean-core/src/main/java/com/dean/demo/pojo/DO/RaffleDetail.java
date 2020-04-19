package com.dean.demo.pojo.DO;

import java.io.Serializable;
import java.util.Date;

public class RaffleDetail implements Serializable {
    private Long raffleDetailId;

    private String awardsName;

    private Integer prizeQuota;

    private Integer betch;

    private String prizeName;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private Long raffleActiveId;

    private String raffleRank;

    private Integer raffleDetailStatus;

    private static final long serialVersionUID = 1L;

    public Long getRaffleDetailId() {
        return raffleDetailId;
    }

    public void setRaffleDetailId(Long raffleDetailId) {
        this.raffleDetailId = raffleDetailId;
    }

    public String getAwardsName() {
        return awardsName;
    }

    public void setAwardsName(String awardsName) {
        this.awardsName = awardsName == null ? null : awardsName.trim();
    }

    public Integer getPrizeQuota() {
        return prizeQuota;
    }

    public void setPrizeQuota(Integer prizeQuota) {
        this.prizeQuota = prizeQuota;
    }

    public Integer getBetch() {
        return betch;
    }

    public void setBetch(Integer betch) {
        this.betch = betch;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getRaffleActiveId() {
        return raffleActiveId;
    }

    public void setRaffleActiveId(Long raffleActiveId) {
        this.raffleActiveId = raffleActiveId;
    }

    public String getRaffleRank() {
        return raffleRank;
    }

    public void setRaffleRank(String raffleRank) {
        this.raffleRank = raffleRank == null ? null : raffleRank.trim();
    }

    public Integer getRaffleDetailStatus() {
        return raffleDetailStatus;
    }

    public void setRaffleDetailStatus(Integer raffleDetailStatus) {
        this.raffleDetailStatus = raffleDetailStatus;
    }
}