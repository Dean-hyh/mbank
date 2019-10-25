package com.ms.credit.dao;

import com.ms.credit.pojo.DO.Role;
import com.ms.credit.pojo.DO.UserRole;
import com.ms.credit.pojo.DO.UserRoleExample;
import com.ms.credit.pojo.DO.UserRoleKey;
import com.ms.credit.pojo.VO.RoleVO;

import java.util.List;

public interface UserRoleDao {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleExample example);

    UserRole selectByPrimaryKey(UserRoleKey key);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<String> selectByUid(String id);
}