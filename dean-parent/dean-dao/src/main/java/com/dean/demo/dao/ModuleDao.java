package com.dean.demo.dao;

import com.dean.demo.datasource.DataSource;
import com.dean.demo.pojo.DO.Module;
import com.dean.demo.pojo.DO.ModuleExample;

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