package com.dean.demo.dao;

import com.dean.demo.pojo.DO.RaffleDetail;
import com.dean.demo.pojo.DO.RaffleDetailExample;
import java.util.List;

public interface RaffleDetailDao {
    int deleteByPrimaryKey(Long raffleDetailId);

    int insert(RaffleDetail record);

    int insertSelective(RaffleDetail record);

    List<RaffleDetail> selectByExample(RaffleDetailExample example);

    RaffleDetail selectByPrimaryKey(Long raffleDetailId);

    int updateByPrimaryKeySelective(RaffleDetail record);

    int updateByPrimaryKey(RaffleDetail record);
}