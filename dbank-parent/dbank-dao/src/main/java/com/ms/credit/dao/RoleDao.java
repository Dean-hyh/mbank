package com.ms.credit.dao;

import com.ms.credit.datasource.DataSource;
import com.ms.credit.pojo.DO.Role;
import com.ms.credit.pojo.DO.RoleExample;

import java.util.List;

public interface RoleDao {
    @DataSource(value = "master")
    int deleteByPrimaryKey(String roleId);

    @DataSource(value = "master")
    int insert(Role record);

    @DataSource(value = "master")
    int insertSelective(Role record);

    @DataSource(value = "slave")
    List<Role> selectByExample(RoleExample example);

    @DataSource(value = "slave")
    Role selectByPrimaryKey(String roleId);

    @DataSource(value = "master")
    int updateByPrimaryKeySelective(Role record);

    @DataSource(value = "master")
    int updateByPrimaryKey(Role record);

    @DataSource(value = "slave")
    List<Role> selectByUserId(String id);


}