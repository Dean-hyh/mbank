package com.ms.credit.dao;

import com.ms.credit.pojo.Perm;
import com.ms.credit.pojo.PermExample;
import java.util.List;

public interface PermDao {
    int deleteByPrimaryKey(String permId);

    int insert(Perm record);

    int insertSelective(Perm record);

    List<Perm> selectByExample(PermExample example);

    Perm selectByPrimaryKey(String permId);

    int updateByPrimaryKeySelective(Perm record);

    int updateByPrimaryKey(Perm record);
}