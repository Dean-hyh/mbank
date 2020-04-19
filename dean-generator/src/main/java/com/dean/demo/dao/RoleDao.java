package com.dean.demo.dao;

import com.dean.demo.pojo.DO.Role;
import com.dean.demo.pojo.DO.RoleExample;
import java.util.List;

public interface RoleDao {
    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}