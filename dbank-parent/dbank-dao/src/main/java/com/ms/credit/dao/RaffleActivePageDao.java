package com.ms.credit.dao;

import com.ms.credit.pojo.DO.RaffleActivePage;
import com.ms.credit.pojo.DO.RaffleActivePageExample;

import java.util.List;

public interface RaffleActivePageDao {
    int deleteByPrimaryKey(Long raffleActiveId);

    int insert(RaffleActivePage record);

    int insertSelective(RaffleActivePage record);

    List<RaffleActivePage> selectByExample(RaffleActivePageExample example);

    RaffleActivePage selectByPrimaryKey(Long raffleActiveId);

    int updateByPrimaryKeySelective(RaffleActivePage record);

    int updateByPrimaryKey(RaffleActivePage record);
}