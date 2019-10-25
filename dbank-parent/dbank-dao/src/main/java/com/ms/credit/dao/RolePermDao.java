package com.ms.credit.dao;

import com.ms.credit.pojo.DO.RolePermExample;
import com.ms.credit.pojo.DO.RolePermKey;

import java.util.List;

public interface RolePermDao {
    int deleteByPrimaryKey(RolePermKey key);

    int insert(RolePermKey record);

    int insertSelective(RolePermKey record);

    List<RolePermKey> selectByExample(RolePermExample example);
}