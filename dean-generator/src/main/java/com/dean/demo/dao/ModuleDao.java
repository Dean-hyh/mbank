package com.dean.demo.dao;

import com.dean.demo.pojo.DO.Module;
import com.dean.demo.pojo.DO.ModuleExample;
import java.util.List;

public interface ModuleDao {
    int deleteByPrimaryKey(String moduleId);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(String moduleId);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}