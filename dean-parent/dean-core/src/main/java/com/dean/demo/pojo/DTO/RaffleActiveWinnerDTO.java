package com.dean.demo.pojo.DTO;

import java.io.Serializable;
import java.util.Date;

public class RaffleActiveWinnerDTO implements Serializable {
    private Long activeWinnerId;

    private Long raffleActiveId;

    private Long raffleDetailId;

    private String custNo;

    private String custName;

    private String custTel;

    private String custId;

    private String custDesc;

    private String raffleActiveName;

    private String awardsName;

    private String prizeName;

    private Date raffleActiveTime;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getActiveWinnerId() {
        return activeWinnerId;
    }

    public void setActiveWinnerId(Long activeWinnerId) {
        this.activeWinnerId = activeWinnerId;
    }

    public Long getRaffleActiveId() {
        return raffleActiveId;
    }

    public void setRaffleActiveId(Long raffleActiveId) {
        this.raffleActiveId = raffleActiveId;
    }

    public Long getRaffleDetailId() {
        return raffleDetailId;
    }

    public void setRaffleDetailId(Long raffleDetailId) {
        this.raffleDetailId = raffleDetailId;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustTel() {
        return custTel;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel == null ? null : custTel.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getCustDesc() {
        return custDesc;
    }

    public void setCustDesc(String custDesc) {
        this.custDesc = custDesc == null ? null : custDesc.trim();
    }

    public String getRaffleActiveName() {
        return raffleActiveName;
    }

    public void setRaffleActiveName(String raffleActiveName) {
        this.raffleActiveName = raffleActiveName == null ? null : raffleActiveName.trim();
    }

    public String getAwardsName() {
        return awardsName;
    }

    public void setAwardsName(String awardsName) {
        this.awardsName = awardsName == null ? null : awardsName.trim();
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName == null ? null : prizeName.trim();
    }

    public Date getRaffleActiveTime() {
        return raffleActiveTime;
    }

    public void setRaffleActiveTime(Date raffleActiveTime) {
        this.raffleActiveTime = raffleActiveTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}