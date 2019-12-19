package com.ms.credit.pojo.VO;

import java.io.Serializable;

public class RaffleDetailVO implements Serializable {
    private String awardsName;

    private Integer prizeQuota;

    private Integer betch;

    private static final long serialVersionUID = 1L;

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
}