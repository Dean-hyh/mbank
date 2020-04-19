package com.dean.demo.service;

import com.dean.demo.pojo.VO.RoleVO;

import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/29 17:45
 */
public interface RoleService {
    Map<String,Object> queryRoleList();

    RoleVO queryRole(String roleId);
}
