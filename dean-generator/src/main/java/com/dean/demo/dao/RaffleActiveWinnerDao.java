package com.dean.demo.dao;

import com.dean.demo.pojo.DO.RaffleActiveWinner;
import com.dean.demo.pojo.DO.RaffleActiveWinnerExample;
import java.util.List;

public interface RaffleActiveWinnerDao {
    int deleteByPrimaryKey(Long activeWinnerId);

    int insert(RaffleActiveWinner record);

    int insertSelective(RaffleActiveWinner record);

    List<RaffleActiveWinner> selectByExample(RaffleActiveWinnerExample example);

    RaffleActiveWinner selectByPrimaryKey(Long activeWinnerId);

    int updateByPrimaryKeySelective(RaffleActiveWinner record);

    int updateByPrimaryKey(RaffleActiveWinner record);
}