package com.ms.credit.dao;

import com.ms.credit.pojo.Role;
import com.ms.credit.pojo.RoleExample;
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