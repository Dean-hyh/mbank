package com.dean.demo.pojo.DO;

import java.io.Serializable;
import java.util.Date;

public class RaffleActivePage implements Serializable {
    private Long raffleActiveId;

    private String raffleActiveName;

    private Integer awards;

    private Boolean isAllowedDuplicates;

    private Date raffleActiveTime;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String backgroundImgUrl;

    private String namelistKey;

    private Integer raffleStatus;

    private Integer totalPrizeQuota;

    private Integer totalBatch;

    private static final long serialVersionUID = 1L;

    public Long getRaffleActiveId() {
        return raffleActiveId;
    }

    public void setRaffleActiveId(Long raffleActiveId) {
        this.raffleActiveId = raffleActiveId;
    }

    public String getRaffleActiveName() {
        return raffleActiveName;
    }

    public void setRaffleActiveName(String raffleActiveName) {
        this.raffleActiveName = raffleActiveName == null ? null : raffleActiveName.trim();
    }

    public Integer getAwards() {
        return awards;
    }

    public void setAwards(Integer awards) {
        this.awards = awards;
    }

    public Boolean getIsAllowedDuplicates() {
        return isAllowedDuplicates;
    }

    public void setIsAllowedDuplicates(Boolean isAllowedDuplicates) {
        this.isAllowedDuplicates = isAllowedDuplicates;
    }

    public Date getRaffleActiveTime() {
        return raffleActiveTime;
    }

    public void setRaffleActiveTime(Date raffleActiveTime) {
        this.raffleActiveTime = raffleActiveTime;
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

    public String getBackgroundImgUrl() {
        return backgroundImgUrl;
    }

    public void setBackgroundImgUrl(String backgroundImgUrl) {
        this.backgroundImgUrl = backgroundImgUrl == null ? null : backgroundImgUrl.trim();
    }

    public String getNamelistKey() {
        return namelistKey;
    }

    public void setNamelistKey(String namelistKey) {
        this.namelistKey = namelistKey == null ? null : namelistKey.trim();
    }

    public Integer getRaffleStatus() {
        return raffleStatus;
    }

    public void setRaffleStatus(Integer raffleStatus) {
        this.raffleStatus = raffleStatus;
    }

    public Integer getTotalPrizeQuota() {
        return totalPrizeQuota;
    }

    public void setTotalPrizeQuota(Integer totalPrizeQuota) {
        this.totalPrizeQuota = totalPrizeQuota;
    }

    public Integer getTotalBatch() {
        return totalBatch;
    }

    public void setTotalBatch(Integer totalBatch) {
        this.totalBatch = totalBatch;
    }
}