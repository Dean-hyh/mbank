package com.ms.credit.service.impl;

import com.ms.credit.dao.RoleDao;
import com.ms.credit.pojo.DO.Role;
import com.ms.credit.pojo.DO.RoleExample;
import com.ms.credit.pojo.VO.RoleVO;
import com.ms.credit.service.RoleService;
import com.ms.credit.utils.BeanHelper;
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
