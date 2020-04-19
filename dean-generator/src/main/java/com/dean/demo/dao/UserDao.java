package com.dean.demo.dao;

import com.dean.demo.pojo.DO.User;
import com.dean.demo.pojo.DO.UserExample;
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