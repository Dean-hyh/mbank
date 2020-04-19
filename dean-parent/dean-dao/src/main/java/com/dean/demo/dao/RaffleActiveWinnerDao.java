package com.dean.demo.dao;

import com.dean.demo.datasource.DataSource;
import com.dean.demo.pojo.DO.RaffleActiveWinner;
import com.dean.demo.pojo.DO.RaffleActiveWinnerExample;

import java.util.List;
import java.util.Map;

public interface RaffleActiveWinnerDao {
    @DataSource(value = "master")
    int deleteByPrimaryKey(Long activeWinnerId);

    @DataSource(value = "master")
    int insert(RaffleActiveWinner record);

    @DataSource(value = "master")
    int insertSelective(RaffleActiveWinner record);

    @DataSource(value = "slave")
    List<RaffleActiveWinner> selectByExample(RaffleActiveWinnerExample example);

    @DataSource(value = "slave")
    RaffleActiveWinner selectByPrimaryKey(Long activeWinnerId);

    @DataSource(value = "master")
    int updateByPrimaryKeySelective(RaffleActiveWinner record);

    @DataSource(value = "master")
    int updateByPrimaryKey(RaffleActiveWinner record);

    @DataSource(value = "slave")
    List<RaffleActiveWinner> selectByRaffleAcriveId(Long raffleAcriveId);

    @DataSource(value = "slave")
    List<Map<String,Object>> queryTest(Map params);

    @DataSource(value = "slave")
    Map<String,Object> queryTest1(Map<String, Object> params);
}