package com.dean.demo.dao;

import com.dean.demo.datasource.DataSource;
import com.dean.demo.pojo.DO.Role;
import com.dean.demo.pojo.DO.RoleExample;

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