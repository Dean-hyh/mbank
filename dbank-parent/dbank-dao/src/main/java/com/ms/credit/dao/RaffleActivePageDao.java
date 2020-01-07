package com.ms.credit.dao;

import com.ms.credit.datasource.DataSource;
import com.ms.credit.pojo.DO.RaffleActivePage;
import com.ms.credit.pojo.DO.RaffleActivePageExample;

import java.util.List;

public interface RaffleActivePageDao {
    @DataSource(value = "master")
    int deleteByPrimaryKey(Long raffleActiveId);

    @DataSource(value = "master")
    int insert(RaffleActivePage record);

    @DataSource(value = "master")
    int insertSelective(RaffleActivePage record);

    @DataSource(value = "slave")
    List<RaffleActivePage> selectByExample(RaffleActivePageExample example);

    @DataSource(value = "slave")
    RaffleActivePage selectByPrimaryKey(Long raffleActiveId);

    @DataSource(value = "master")
    int updateByPrimaryKeySelective(RaffleActivePage record);

    @DataSource(value = "master")
    int updateByPrimaryKey(RaffleActivePage record);

}