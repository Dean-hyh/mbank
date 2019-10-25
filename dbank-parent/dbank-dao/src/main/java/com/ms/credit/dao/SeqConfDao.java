package com.ms.credit.dao;

import com.ms.credit.pojo.DO.SeqConf;
import com.ms.credit.pojo.DO.SeqConfExample;

import java.util.List;

public interface SeqConfDao {
    int deleteByPrimaryKey(String seqId);

    int insert(SeqConf record);

    int insertSelective(SeqConf record);

    List<SeqConf> selectByExample(SeqConfExample example);

    SeqConf selectByPrimaryKey(String seqId);

    int updateByPrimaryKeySelective(SeqConf record);

    int updateByPrimaryKey(SeqConf record);
}