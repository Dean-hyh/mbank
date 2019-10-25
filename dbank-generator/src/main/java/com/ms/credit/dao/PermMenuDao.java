package com.ms.credit.dao;

import com.ms.credit.pojo.PermMenuExample;
import com.ms.credit.pojo.PermMenuKey;
import java.util.List;

public interface PermMenuDao {
    int deleteByPrimaryKey(PermMenuKey key);

    int insert(PermMenuKey record);

    int insertSelective(PermMenuKey record);

    List<PermMenuKey> selectByExample(PermMenuExample example);
}