package com.ms.credit.dao;

import com.ms.credit.pojo.DO.Org;
import com.ms.credit.pojo.DO.OrgExample;

import java.util.List;

public interface OrgDao {
    int deleteByPrimaryKey(String orgId);

    int insert(Org record);

    int insertSelective(Org record);

    List<Org> selectByExample(OrgExample example);

    Org selectByPrimaryKey(String orgId);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKey(Org record);
}