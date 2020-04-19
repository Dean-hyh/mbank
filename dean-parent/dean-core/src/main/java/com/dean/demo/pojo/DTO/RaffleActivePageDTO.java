package com.dean.demo.pojo.DTO;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RaffleActivePageDTO implements Serializable {

    private Long raffleActiveId;

    private String raffleActiveName;

    private Integer awards;

    private Integer totalPrizeQuota;

    private Integer totalBatch;

    private Boolean isAllowedDuplicates;

    private Date raffleActiveTime;

    private String backgroundImgUrl;

    /**
     * 名单及背景图
     */
    private MultipartFile[] files;

    /**
     * 抽奖详情
     */
    private List<RaffleDetailDTO> raffleDetailList;

    private String createUser;

    private String updateUser;

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

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public List<RaffleDetailDTO> getRaffleDetailList() {
        return raffleDetailList;
    }

    public void setRaffleDetailList(List<RaffleDetailDTO> raffleDetailList) {
        this.raffleDetailList = raffleDetailList;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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

    public String getBackgroundImgUrl() {
        return backgroundImgUrl;
    }

    public void setBackgroundImgUrl(String backgroundImgUrl) {
        this.backgroundImgUrl = backgroundImgUrl;
    }
}