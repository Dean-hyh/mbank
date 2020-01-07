package com.ms.credit.controller;

import com.ms.credit.BaseController;
import com.ms.credit.utils.CurrentLineInfo;
import com.ms.credit.utils.JsonUtils;
import com.ms.framework.Context;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/10/31 15:25
 */
@RestController
@RequestMapping("/context")
public class ContextController extends BaseController{
    @RequestMapping(value = "/test", method = RequestMethod.PUT)
    public ResponseEntity<Map> getMap(Context context) {
        Map<String, Object> reData = new HashMap<>();
        Map reqMap = context.containsKey("request") ? context.get("request", Map.class) : null;
        if (reqMap != null && reqMap.containsKey("body")) {
            Map bodyMap = (Map) reqMap.get("body");
            String isThirdLogin = (String) bodyMap.get("_isThirdLogin");
            reData.put("三方用户",isThirdLogin);
        }
        return ResponseEntity.ok(reData);
    }

    @RequestMapping(value = "/getCurrentThread",method = RequestMethod.GET)
    public ResponseEntity<String> getCurrentThread(){
        String currentThread = CurrentLineInfo.getFileAddress();
        return ResponseEntity.ok(currentThread);
    }
}
