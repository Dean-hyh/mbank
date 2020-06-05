package com.dean.demo.service.impl;

import com.dean.demo.dao.RoleDao;
import com.dean.demo.pojo.DO.Role;
import com.dean.demo.pojo.DO.RoleExample;
import com.dean.demo.pojo.VO.RoleVO;
import com.dean.demo.service.RoleService;
import com.dean.demo.utils.BeanHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/29 17:53
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Map<String,Object> queryRoleList() {
        RoleExample example = new RoleExample();
        List<Role> roleList = roleDao.selectByExample(example);
        Map<String,Object> reqMap = new HashMap<>();
        reqMap.put("yuanh",roleList);
        return reqMap;
    }

    @Override
    public RoleVO queryRole(String roleId) {
        Role role = roleDao.selectByPrimaryKey(roleId);
        RoleVO roleVO = BeanHelper.copyProperties(role, RoleVO.class);
        return roleVO;
    }
}