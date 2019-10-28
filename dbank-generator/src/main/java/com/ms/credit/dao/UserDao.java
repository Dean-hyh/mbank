package com.ms.credit.dao;

import com.ms.credit.pojo.User;
import com.ms.credit.pojo.UserExample;
import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}