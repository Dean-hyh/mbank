package com.ms.credit.dao;

import com.ms.credit.pojo.UserRole;
import com.ms.credit.pojo.UserRoleExample;
import com.ms.credit.pojo.UserRoleKey;
import java.util.List;

public interface UserRoleDao {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleExample example);

    UserRole selectByPrimaryKey(UserRoleKey key);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}