package com.ms.credit.pojo.DTO;

import java.io.Serializable;

public class RaffleDetailDTO implements Serializable {
    private Long raffleDetailId;

    private String awardsName;

    private Integer prizeQuota;

    private Integer betch;

    private String prizeName;

    private Long raffleActiveId;

    private String raffleRank;

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
        this.raffleRank = raffleRank;
    }
}