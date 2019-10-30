package com.ms.credit.controller;

import com.ms.credit.BaseController;
import com.ms.credit.enums.DbankExceptionEnum;
import com.ms.credit.exception.DbankException;
import com.ms.credit.pojo.DO.User;
import com.ms.credit.pojo.VO.RoleVO;
import com.ms.credit.pojo.VO.UserVO;
import com.ms.credit.service.UserService;
import com.ms.credit.utils.JsonUtils;
import com.ms.credit.utils.RandomValueUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/20 16:46
 */

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    private static Log log = LogFactory.getLog(UserController.class);

    /**
     * 查询用户列表
     */
    @RequestMapping(value = "/userList",method = RequestMethod.GET)
    public ResponseEntity<List<UserVO>> findUserList() {
        List<UserVO> userList = userService.queryUserList();
        return ResponseEntity.ok(userList);
    }

    /**
     * 依据ID查询单个用户
     *
     * @param id 主键
     * @return 返回UserVO对象
     */
    @RequestMapping(value = "/queryUserById/{id}" ,method = RequestMethod.GET)
    public Object queryUserById(@PathVariable("id") String id) {
        if (StringUtils.isEmpty(id)) {
            throw new DbankException(DbankExceptionEnum.INVALID_PARAM_ERROR);
        }
        return userService.queryUserById(id);
    }

    /**
     * 添加用户
     *
     * @param user 前端传递的参数
     * @return 返回状态码
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(User user) {
        String userId = "U000000000000000";
        String prefix = UUID.randomUUID().toString().substring(0,4);
        userId = userId+prefix;
        user.setUserId(userId);
        user.setDeptId("100");
        user.setEmail(prefix.substring(0,2)+"_dean@gamil.com");
        user.setUserName(prefix.substring(0,2)+"_dean");
        String[] arr = {"Java/WEB开发","Python","IOS","Android","前端","C#","C++",".net","PHP"};
        user.setStation(arr[new Random().nextInt(9)+1]);
        user.setPassword(UUID.randomUUID().toString());
        user.setState(0L);
        user.setCompanyId("U000");
        user.setCompanyName("Dean.Co.Ltd");
        user.setDeptName("技术部");
        user.setGender((String.valueOf(new Random().nextInt(2))));
        user.setTelephone(RandomValueUtil.getTel());
        user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        user.setDegree(new Random().nextInt(5));
        user.setSalary(12000L);
        user.setJoinDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        user.setCreateBy(userId);
        user.setCreateDept("100");
        user.setCreateTime(new Date());
        user.setUpdateBy(userId);
        user.setUpdateTime(new Date());
        user.setRemark("nameless");
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 修改用户
     *
     * @param id 用户主键id
     * @return 查询结果--状态码
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUserById(@PathVariable("id") String id) {
        if (StringUtils.isEmpty(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        userService.updateUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 删除用户
     * TODO 需要先删除用户-角色中间表中的用户数据
     * @param id 用户主键id
     * @return 查询结果--状态码，无查询结果
     */
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") String id) {
        if (StringUtils.isEmpty(id)) {
            throw new DbankException(DbankExceptionEnum.INVALID_PARAM_ERROR);
        }
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 查询用户是否存在
     *
     * @param id 主键ID
     * @return 查询结果--状态码及boolean结果
     */
    @RequestMapping(value = "/isExit/{id}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> isExit(@PathVariable("id") String id) {
        if (StringUtils.isEmpty(id)) {
            return ResponseEntity.ok(false);
        }
        Boolean exit = userService.isExit(id);
        return ResponseEntity.ok(exit);
    }

    /**
     * 根据用户Id查询用户角色
     * @param userId
     * @return
     */
    @RequestMapping(value = "/queryRoleByUserId/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<RoleVO>> queryRoleByUserId(@PathVariable("userId") String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new DbankException(DbankExceptionEnum.INVALID_PARAM_ERROR);
        }
        List<RoleVO> roleList = userService.queryRoleByUid(userId);
        return ResponseEntity.ok(roleList);
    }
}