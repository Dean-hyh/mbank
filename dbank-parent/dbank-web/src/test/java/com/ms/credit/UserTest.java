package com.ms.credit;

import com.ms.credit.dao.RoleDao;
import com.ms.credit.dao.UserDao;
import com.ms.credit.dao.UserRoleDao;
import com.ms.credit.pojo.DO.Role;
import com.ms.credit.pojo.DO.UserRole;
import com.ms.credit.pojo.VO.RoleVO;
import com.ms.credit.pojo.VO.UserVO;
import com.ms.credit.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/20 17:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:**/applicationContext-dao.xml","classpath*:**/applicationContext-service.xml"})
public class UserTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private UserDao userDao;

   @Test
    public void userTest(){
        List<UserVO> userList = userService.queryUserList();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=");
        for (UserVO user : userList) {
            System.out.println(user.getLoginName());
        }
        System.out.println(userList);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=");
    }

    @Test
    public void method(){
        //List<String> list = userRoleDao.selectByUid("U0000000000000000083");
        //Role role = roleDao.selectByPrimaryKey("R0000000000000000002");
        //List<Role> roleList = roleDao.selectByUserId("U0000000000000000083");
        List<String> list = userRoleDao.selectByUid("U0000000000000000083");
        System.out.println(list);
    }

    @Test
    public void userDaoT(){
        Boolean exit = userDao.isExit("0");
        System.out.println(exit);
    }
}
