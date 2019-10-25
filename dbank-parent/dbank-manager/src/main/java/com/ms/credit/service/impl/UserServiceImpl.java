package com.ms.credit.service.impl;

import com.ms.credit.dao.RoleDao;
import com.ms.credit.dao.UserDao;
import com.ms.credit.dao.UserRoleDao;
import com.ms.credit.pojo.DO.Role;
import com.ms.credit.pojo.DO.User;
import com.ms.credit.pojo.DO.UserExample;
import com.ms.credit.pojo.VO.RoleVO;
import com.ms.credit.pojo.VO.UserVO;
import com.ms.credit.service.UserService;
import com.ms.credit.utils.BeanHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/20 17:02
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleDao userRoleDao;

    private static Log log = LogFactory.getLog(UserServiceImpl.class);

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UserVO> queryUserList() {
        UserExample userExample = new UserExample();
        List<User> userList = userDao.selectByExample(userExample);
        List<UserVO> userListVO = BeanHelper.copyWithCollection(userList, UserVO.class);
        return userListVO;
    }

    @Override
    public UserVO queryUserById(String uid) {
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(uid);
        User user = userDao.selectByPrimaryKey(uid);
        UserVO userVO = BeanHelper.copyProperties(user, UserVO.class);
        return userVO;
    }

    @Override
    public void addUser(User user) {
        int insert = userDao.insertSelective(user);
        if(insert<1){
            log.error("插入用户失败!");
        }
    }

    @Override
    public void deleteUserById(String id) {
        int delete = userDao.deleteByPrimaryKey(id);
        if(delete<1){
            log.error("删除用户失败！");
        }
    }

    @Override
    public void updateUserById(String id) {
        //查询用户先
        User user = userDao.selectByPrimaryKey(id);
        if(user==null || StringUtils.isEmpty(String.valueOf(user))){
            log.error("查询单个用户失败！");
            return;
        }
        String[] loginName = {"Jack","Jerry","John","Jobs","Tom","Mark"};
        String prefix = UUID.randomUUID().toString().substring(0,4);
        user.setLoginName(loginName[new Random().nextInt(6)+1]+"·"+prefix.substring(0,2));
        user.setUpdateTime(new Date());
        int a = 1/0;
        int update = userDao.updateByPrimaryKey(user);
        if(update<1){
            log.error("修改用户失败！");
        }
    }

    @Override
    public Boolean isExit(String id) {
        Boolean exit = userDao.isExit(id);
        return exit;
    }

    @Override
    public List<RoleVO> queryRoleByUid(String id) {
        List<Role> roles = roleDao.selectByUserId(id);
        List<RoleVO> roleVoList = BeanHelper.copyWithCollection(roles, RoleVO.class);
        return roleVoList;
    }
}
