package com.ms.credit.service.impl;

import com.ms.credit.dao.RoleDao;
import com.ms.credit.dao.UserDao;
import com.ms.credit.enums.DbankExceptionEnum;
import com.ms.credit.exception.DbankException;
import com.ms.credit.pojo.DO.Role;
import com.ms.credit.pojo.DO.User;
import com.ms.credit.pojo.DO.UserExample;
import com.ms.credit.pojo.VO.RoleVO;
import com.ms.credit.pojo.VO.UserVO;
import com.ms.credit.service.UserService;
import com.ms.credit.utils.BeanHelper;
import com.ms.credit.utils.CurrentLineInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
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
//@Transactional  //为实现读写分离，暂不进行事务控制
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;


    private static Log log = LogFactory.getLog(UserServiceImpl.class);

    @Override
    //@Transactional(propagation = Propagation.SUPPORTS)
    public List<UserVO> queryUserList() {
        UserExample userExample = new UserExample();
        List<User> userList = userDao.selectByExample(userExample);
        return BeanHelper.copyWithCollection(userList, UserVO.class);
    }

    @Override
    public UserVO queryUserById(String uid) {
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(uid);
        User user = userDao.selectByPrimaryKey(uid);
        return BeanHelper.copyProperties(user, UserVO.class);
    }

    @Override
    public void addUser(User user) {
        int insert = userDao.insert(user);
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
        //查询用户
        User user = userDao.selectByPrimaryKey(id);
        if(user==null || StringUtils.isEmpty(String.valueOf(user))){
            try {
                log.debug("查询用户信息-->id:"+id +
                        " 时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +
                        " 位置：" + CurrentLineInfo.getFileAddress());
            } catch (Exception e) {
                e.printStackTrace();
            }
            throw new DbankException(DbankExceptionEnum.UPDATE_OPERATION_FAIL);
        }
        String[] email_prefix = {"Jack","Jerry","John","Jobs","Tom","Mark"};
        String prefix = UUID.randomUUID().toString().substring(0,4);
        user.setEmail(email_prefix[new Random().nextInt(6)+1]+"_"+prefix.substring(0,2)+"@gmail.com");
        user.setUpdateTime(new Date());
        int update = userDao.updateByPrimaryKey(user);
        if(update<1){
            log.error("修改用户失败！");
            throw new DbankException(DbankExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    @Override
    public Boolean isExit(String id) {
        return userDao.isExit(id);
    }

    /**
     * 根据用户id查询用户角色信息
     * @param id 用户主键
     * @return roleVoList
     */
    @Override
    public List<RoleVO> queryRoleByUid(String id) {
        List<Role> roles = roleDao.selectByUserId(id);
        List<RoleVO> roleVoList = BeanHelper.copyWithCollection(roles, RoleVO.class);
        if(CollectionUtils.isEmpty(roleVoList)){
            throw new DbankException(DbankExceptionEnum.USER_HAS_NONE_ROLE);
        }
        return roleVoList;
    }
}
