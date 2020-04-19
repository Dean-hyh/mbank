package com.dean.demo.dao;

import com.dean.demo.datasource.DataSource;
import com.dean.demo.pojo.DO.RaffleDetail;
import com.dean.demo.pojo.DO.RaffleDetailExample;

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