package com.ms.credit.dao;

import com.ms.credit.pojo.Func;
import com.ms.credit.pojo.FuncExample;
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