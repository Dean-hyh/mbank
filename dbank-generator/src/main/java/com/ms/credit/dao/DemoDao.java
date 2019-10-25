package com.ms.credit.dao;

import com.ms.credit.pojo.Demo;
import com.ms.credit.pojo.DemoExample;
import java.util.List;

public interface DemoDao {
    int deleteByPrimaryKey(String demoId);

    int insert(Demo record);

    int insertSelective(Demo record);

    List<Demo> selectByExample(DemoExample example);

    Demo selectByPrimaryKey(String demoId);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);
}