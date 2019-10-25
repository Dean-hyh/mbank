package com.ms.credit.service;

import com.ms.credit.pojo.DO.Role;
import com.ms.credit.pojo.VO.RoleVO;
import com.ms.framework.Context;

import java.util.List;
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
