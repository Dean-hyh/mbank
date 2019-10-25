package com.ms.credit.dao;

import com.ms.credit.pojo.DO.PermFuncExample;
import com.ms.credit.pojo.DO.PermFuncKey;

import java.util.List;

public interface PermFuncDao {
    int deleteByPrimaryKey(PermFuncKey key);

    int insert(PermFuncKey record);

    int insertSelective(PermFuncKey record);

    List<PermFuncKey> selectByExample(PermFuncExample example);
}