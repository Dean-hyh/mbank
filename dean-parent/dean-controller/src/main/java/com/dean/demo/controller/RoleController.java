package com.dean.demo.controller;

import com.alibaba.fastjson.JSON;
import com.dean.demo.BaseController;
import com.dean.demo.pojo.VO.RoleVO;
import com.dean.demo.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/9/29 17:41
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService contextService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 查询角色列表
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> queryRoleList() {
        Map<String, Object> map = contextService.queryRoleList();
        return ResponseEntity.ok(map);
    }

    /**
     * 原生HttpServlet接收json格式数据演示
     *
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/req", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> jsonReq(HttpServletRequest request) throws IOException {
        //原生HttpServletRequest接收JSON格式数据（流处理）
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        Map<String, String> reqMap = new HashMap<>();
        String inputStr;
        while ((inputStr = reader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
            reqMap = JSON.parseObject(responseStrBuilder.toString(), Map.class);
        }
        String name = reqMap.get("name");
        String header = reqMap.get("header");
        String requestURL = request.getRequestURL().toString();
        //组装出参
        Map<String, Object> map = new HashMap<>();
        map.put("_isThirdLogin", "mietuan");
        map.put("url", requestURL);
        map.put("name", name);
        map.put("header", header);

        HttpSession session = request.getSession();

        Map<String, Object> hashMap = new HashMap<>();
        String method = request.getMethod().toString();
        String remoteHost = request.getRemoteHost();
        String URI = request.getRequestURI();
        String remo = request.getRemoteAddr().toString();
        hashMap.put("method",method);
        hashMap.put("remoteHost",remoteHost);
        hashMap.put("URI",URI);
        hashMap.put("remo",remo);
        map.put("hashMap",hashMap);


        return ResponseEntity.ok(map);
    }

    /**
     * 依据用户Id查询用户角色
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/queryRoleById")
    public ResponseEntity<RoleVO> queryRoleById(HttpServletRequest request) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        Map<String, String> reqMap = new HashMap<>();
        String inputStr;
        while ((inputStr = reader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
            reqMap = JSON.parseObject(responseStrBuilder.toString(), Map.class);
        }
        String roleId = reqMap.get("roleId");
        RoleVO role = contextService.queryRole(roleId);
        return ResponseEntity.ok(role);
    }

    /**
     * 依据用户Id查询用户角色
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/showFushu")
    public ResponseEntity<Map<String,String>> showFushu(HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("数字1","1");
        map.put("数字2","2");
        map.put("数字3","-100");
        map.put("数字4","-10.0");
        return ResponseEntity.ok(map);
    }
}
