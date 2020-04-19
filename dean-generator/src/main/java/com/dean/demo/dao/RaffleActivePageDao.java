package com.dean.demo.dao;

import com.dean.demo.pojo.DO.RaffleActivePage;
import com.dean.demo.pojo.DO.RaffleActivePageExample;
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