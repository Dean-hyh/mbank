package com.ms.credit.dao;

import com.ms.credit.pojo.DO.RaffleActiveWinner;
import com.ms.credit.pojo.DO.RaffleActiveWinnerExample;
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