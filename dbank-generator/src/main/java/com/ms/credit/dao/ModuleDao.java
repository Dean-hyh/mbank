package com.ms.credit.dao;

import com.ms.credit.pojo.DO.Module;
import com.ms.credit.pojo.DO.ModuleExample;
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