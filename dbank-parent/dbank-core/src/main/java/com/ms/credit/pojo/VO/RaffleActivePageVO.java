package com.ms.credit.pojo.VO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 抽奖活动页列表展示VO
 */
public class RaffleActivePageVO implements Serializable {

    private Long raffleActiveId;

    private String raffleActiveName;

    private Integer awards;

    List<RaffleDetailVO> raffleDetailVoList;

    private Boolean isAllowedDuplicates;

    /*抽奖时间*/
    private Date raffleActiveTime;

    /*更新时间*/
    private Date updateTime;

    private Integer raffleStatus;

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

    public Integer getRaffleStatus() {
        return raffleStatus;
    }

    public void setRaffleStatus(Integer raffleStatus) {
        this.raffleStatus = raffleStatus;
    }

    public List<RaffleDetailVO> getRaffleDetailVoList() {
        return raffleDetailVoList;
    }

    public void setRaffleDetailVoList(List<RaffleDetailVO> raffleDetailVoList) {
        this.raffleDetailVoList = raffleDetailVoList;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}