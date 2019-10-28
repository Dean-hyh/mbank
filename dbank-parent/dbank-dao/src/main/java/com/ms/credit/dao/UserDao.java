package com.ms.credit.dao;

import com.ms.credit.datasource.DataSource;
import com.ms.credit.pojo.DO.User;
import com.ms.credit.pojo.DO.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    @DataSource(value = "master")
    int deleteByPrimaryKey(String userId);

    @DataSource(value = "master")
    int insert(User record);

    @DataSource(value = "master")
    int insertSelective(User record);

    @DataSource(value = "slave")
    List<User> selectByExample(UserExample example);

    @DataSource(value = "slave")
    User selectByPrimaryKey(String userId);

    @DataSource(value = "master")
    int updateByPrimaryKeySelective(User record);

    @DataSource(value = "master")
    int updateByPrimaryKey(User record);

    @DataSource(value = "slave")
    boolean isExit(@Param("id") String id);
}