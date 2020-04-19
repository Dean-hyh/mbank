package com.dean.demo.service;

import com.dean.demo.pojo.DO.User;
import com.dean.demo.pojo.VO.RoleVO;
import com.dean.demo.pojo.VO.UserVO;

import java.util.List;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/20 17:02
 */
public interface UserService {
    List<UserVO> queryUserList();

    UserVO queryUserById(String uid);

    void addUser(User user);

    void deleteUserById(String id);

    void updateUserById(String id);

    Boolean isExit(String id);

    List<RoleVO> queryRoleByUid(String id);
}
