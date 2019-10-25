package com.ms.credit.service;

import com.ms.credit.pojo.DO.User;
import com.ms.credit.pojo.VO.RoleVO;
import com.ms.credit.pojo.VO.UserVO;

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
