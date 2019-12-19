package com.ms.credit.dao;

import com.ms.credit.pojo.DO.RaffleDetail;
import com.ms.credit.pojo.DO.RaffleDetailExample;

import java.util.List;

public interface RaffleDetailDao {
    int deleteByPrimaryKey(Long raffleDetailId);

    int insert(RaffleDetail record);

    int insertSelective(RaffleDetail record);

    List<RaffleDetail> selectByExample(RaffleDetailExample example);

    RaffleDetail selectByPrimaryKey(Long raffleDetailId);

    int updateByPrimaryKeySelective(RaffleDetail record);

    int updateByPrimaryKey(RaffleDetail record);

    int deleteByRaffleActiveId(Long raffleActiveId);
}