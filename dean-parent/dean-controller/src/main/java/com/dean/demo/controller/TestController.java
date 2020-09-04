package com.dean.demo.controller;

import cfca.sadk.cmbc.tools.CMBCDecryptKit;
import cfca.sadk.cmbc.tools.DecryptKitException;
import cmbc.cfca.util.Base64;
import com.dean.demo.BaseController;
import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/21 17:13
 */
@RestController
@RequestMapping("/testCtrl")
public class TestController extends BaseController {

    @RequestMapping(value = "/one/{num}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> testCtrl(@PathVariable("num") Integer num) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> resp = new HashMap<>();
        if (num % 2 == 1) {
            Map<Integer, Object> oddMap = getOddResp(num);
            resp.put("方法1", oddMap);
        } else {
            Map<Integer, Object> evenMap = getEvenResp(num);
            resp.put("方法2", evenMap);
        }
        result.put("输入的值是：", num);
        result.put("获取到的结果是：", resp);
        return ResponseEntity.ok(result);
    }

    private Map<Integer, Object> getEvenResp(Integer num) {
        Map<Integer, Object> evenMap = new HashMap<>();
        evenMap.put(num, "偶数，调用方法：getEvenResp");
        evenMap.put(num++,getObject());
        return evenMap;
    }

    private Map<Integer, Object> getOddResp(Integer num) {
        Map<Integer, Object> oddMap = new HashMap<>();
        oddMap.put(num, "奇数，调用方法：getOddResp");
        return oddMap;
    }

    private Map<String,Object> getObject() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("name","zhangsan");
        objectMap.put("age",20);
        objectMap.put("gender","未知");
        return objectMap;
    }

    @RequestMapping(value = "/yuanTest",method = RequestMethod.POST)
    public ResponseEntity<Void> test2(@RequestParam("spbhList") List<String> str,@RequestParam("checkLogin")String isLogin) {
        System.out.println(str + isLogin);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @RequestMapping(value = "/encrypt",method = RequestMethod.POST)
    public ResponseEntity<String> test3(@RequestParam(value="dreamOrderNo",required = false) String dreamOrderNo,
                                        @RequestParam(value="transDesc",required = false) String transDesc,
                                        @RequestParam(value="dreamValue",required = false) String dreamValue,
                                        @RequestParam(value="transDate",required = false) String transDate,
                                        @RequestParam(value="transTime",required = false) String transTime,
                                        @RequestParam(value="taskId",required = false) String taskId){
        HashMap<String, Object> params = new HashMap<>();
        params.put("dreamOrderNo",dreamOrderNo);
        params.put("transDesc",transDesc);
        params.put("dreamValue",dreamValue);
        params.put("transDate",transDate);
        params.put("transTime",transTime);
        params.put("taskId",taskId);
        JSONObject json = JSONObject.fromObject(params);
        String sourceData = json.toString();
        String encryptStr="";
        try {
            String userPlainBase64Text = new String(Base64.encode(sourceData.getBytes()));
            CMBCDecryptKit decryptKit = new CMBCDecryptKit();
            // 私钥
            String userPrivateFile = "D:\\idea\\ideaSpace_bank\\client\\client.sm2";
            // 文件密码
            String userPrivateFilePassword = "111111";
            // 银行端证书
            String cmbcPublicCertFile = "D:\\idea\\ideaSpace_bank\\bankc\\bank.cer";
            int result = decryptKit.Initialize(userPrivateFile, userPrivateFilePassword, cmbcPublicCertFile);
            System.out.println("init result:" + result);
            if(result == 0){
                // 调用工具类，返回签名加密结果
                String userEnvelopebase64Message = decryptKit.SignAndEncryptMessage(userPlainBase64Text);
                System.out.println("sign and encrypt message:" + userEnvelopebase64Message);
                // 再对加密签名结果base64
                byte[] base = Base64.encode(userEnvelopebase64Message.getBytes());
                // 输出最终加密签名结果
                System.out.println("-----------------------------");
                encryptStr = new String(base);
            }
        } catch (DecryptKitException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(encryptStr);
    }

    @RequestMapping(value = "/decrypt",method = RequestMethod.POST)
    public ResponseEntity<String> test4(@RequestParam("resp") String encryStr) {
        String decryptStr="";
        try {
            byte[] encryDecodeStr = Base64.decode(encryStr);
            String cmbcEnvelopeBase64Text = new String(encryDecodeStr);
            String userPrivateFile1 = "D:\\idea\\ideaSpace_bank\\client\\client.sm2";
            String userPrivateFilePassword1 = "111111";
            String cmbcPublicCertFile1 = "D:\\idea\\ideaSpace_bank\\bankc\\bank.cer";
            CMBCDecryptKit decryptKit1 = new CMBCDecryptKit();
            int result1 = decryptKit1.Initialize(userPrivateFile1, userPrivateFilePassword1, cmbcPublicCertFile1);
            if(result1 == 0){
                // 调用工具类，返回解密验签结果，base64格式
                String userSourceBase64Text = decryptKit1.DecryptAndVerifyMessage(cmbcEnvelopeBase64Text);
                // 最终解密后数据
                decryptStr = new String(Base64.decode(userSourceBase64Text));
                System.out.println(decryptStr);
            }
        } catch (DecryptKitException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(decryptStr);
    }
}
