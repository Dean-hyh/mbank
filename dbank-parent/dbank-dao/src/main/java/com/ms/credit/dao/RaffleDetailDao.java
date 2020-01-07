package com.ms.credit.dao;

import com.ms.credit.datasource.DataSource;
import com.ms.credit.pojo.DO.RaffleDetail;
import com.ms.credit.pojo.DO.RaffleDetailExample;

import java.util.List;

public interface RaffleDetailDao {
    @DataSource(value = "master")
    int deleteByPrimaryKey(Long raffleDetailId);

    @DataSource(value = "master")
    int insert(RaffleDetail record);

    @DataSource(value = "master")
    int insertSelective(RaffleDetail record);

    @DataSource(value = "slave")
    List<RaffleDetail> selectByExample(RaffleDetailExample example);

    @DataSource(value = "slave")
    RaffleDetail selectByPrimaryKey(Long raffleDetailId);

    @DataSource(value = "master")
    int updateByPrimaryKeySelective(RaffleDetail record);

    @DataSource(value = "master")
    int updateByPrimaryKey(RaffleDetail record);

    @DataSource(value = "master")
    int deleteByRaffleActiveId(Long raffleActiveId);
}