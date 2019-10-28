package com.ms.credit.dao;

import com.ms.credit.datasource.DataSource;
import com.ms.credit.pojo.DO.Module;
import com.ms.credit.pojo.DO.ModuleExample;

import java.util.List;

public interface ModuleDao {
    @DataSource(value = "master")
    int deleteByPrimaryKey(String moduleId);

    @DataSource(value = "master")
    int insert(Module record);

    @DataSource(value = "master")
    int insertSelective(Module record);

    @DataSource(value = "slave")
    List<Module> selectByExample(ModuleExample example);

    @DataSource(value = "slave")
    Module selectByPrimaryKey(String moduleId);

    @DataSource(value = "master")
    int updateByPrimaryKeySelective(Module record);

    @DataSource(value = "master")
    int updateByPrimaryKey(Module record);
}