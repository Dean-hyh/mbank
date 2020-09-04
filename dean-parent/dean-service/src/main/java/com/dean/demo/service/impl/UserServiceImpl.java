package com.dean.demo.service.impl;

import com.dean.demo.dao.RoleDao;
import com.dean.demo.dao.UserDao;
import com.dean.demo.enums.DbankExceptionEnum;
import com.dean.demo.exception.DbankException;
import com.dean.demo.pojo.DO.Role;
import com.dean.demo.pojo.DO.User;
import com.dean.demo.pojo.DO.UserExample;
import com.dean.demo.pojo.VO.RoleVO;
import com.dean.demo.pojo.VO.UserVO;
import com.dean.demo.service.UserService;
import com.dean.demo.utils.BeanHelper;
import com.dean.demo.utils.CurrentLineInfo;
import com.dean.demo.utils.JsonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
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
        if(user==null || StringUtils.isEmpty(String.valueOf(user))){
            throw new DbankException(DbankExceptionEnum.USER_NOT_FOUND);
        }
        return BeanHelper.copyProperties(user, UserVO.class);
    }

    @Override
    public void addUser(User user) {
        int insert = userDao.insert(user);
        log.info("插入用户数据:"+ JsonUtils.toString(user)+"\\"+CurrentLineInfo.getFileAddress());
        if (insert < 1) {
            log.error("插入用户失败:"+"\\"+CurrentLineInfo.getFileAddress());
            throw new DbankException(DbankExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    @Override
    public void deleteUserById(String id) {
        //删除中间表数据
        Boolean isDelete = userDao.deleteRoleUser(id);
        //中间表删除成功后删除用户信息
        if(isDelete!=null && isDelete) {
            int delete = userDao.deleteByPrimaryKey(id);
            log.info("删除用户数据:"+ id+"\\"+CurrentLineInfo.getFileAddress());
        }
        if (!isDelete) {
            log.error("删除用户失败！");
            throw new DbankException(DbankExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }

    @Override
    public void updateUserById(String id) {
        //查询用户
        User user = userDao.selectByPrimaryKey(id);
        if (user == null || StringUtils.isEmpty(String.valueOf(user))) {
            log.debug("查询用户信息-->id:" + id + "\\" + CurrentLineInfo.getFileAddress());
            throw new DbankException(DbankExceptionEnum.UPDATE_OPERATION_FAIL);
        }
        String[] email_prefix = {"Jack", "Jerry", "John", "Jobs", "Tom", "Mark"};
        String prefix = UUID.randomUUID().toString().substring(0, 4);
        user.setEmail(email_prefix[new Random().nextInt(6) + 1] + "_" + prefix.substring(0, 2) + "@gmail.com");
        user.setUpdateTime(new Date());
        int update = userDao.updateByPrimaryKey(user);
        if (update < 1) {
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
     *
     * @param id 用户主键
     * @return roleVoList
     */
    @Override
    public List<RoleVO> queryRoleByUid(String id) {
        List<Role> roles = roleDao.selectByUserId(id);
        List<RoleVO> roleVoList = BeanHelper.copyWithCollection(roles, RoleVO.class);
        if (CollectionUtils.isEmpty(roleVoList)) {
            throw new DbankException(DbankExceptionEnum.USER_HAS_NONE_ROLE);
        }
        return roleVoList;
    }

    @Override
    public List<String> selectUserListByDeptId(String deptId) {
        return userDao.selectUserListByDeptId(deptId);
    }
}
