package com.ms.credit.dao;

import com.ms.credit.pojo.DO.Func;
import com.ms.credit.pojo.DO.FuncExample;

import java.util.List;

public interface FuncDao {
    int deleteByPrimaryKey(String name);

    int insert(Func record);

    int insertSelective(Func record);

    List<Func> selectByExample(FuncExample example);

    Func selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Func record);

    int updateByPrimaryKey(Func record);
}