package com.dean.demo.service.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;


public class SendPostReqDemo {
    /**
     * 请求
     * @param xmlInfo
     * @param Url
     * @return
     */
    public static String doHttpPost(String xmlInfo, String Url) {
        System.out.println("发起的数据:" + xmlInfo);
        byte[] xmlData = xmlInfo.getBytes();
        InputStream instr = null;
        ByteArrayOutputStream out = null;
        try {
            final URL url = new URL(Url);
            URLConnection urlCon = url.openConnection();
            urlCon.setDoOutput(true);
            urlCon.setDoInput(true);
            urlCon.setUseCaches(false);
            urlCon.setRequestProperty("content-Type", "application/json");
            urlCon.setRequestProperty("charset", "utf-8");
            DataOutputStream printout = new DataOutputStream(
            urlCon.getOutputStream());
            printout.write(xmlData);
            printout.flush();
            printout.close();
            instr = urlCon.getInputStream();
            byte[] bis = IOUtils.toByteArray(instr);
            String ResponseString = new String(bis, "UTF-8");
            if ((ResponseString == null) || ("".equals(ResponseString.trim()))) {
                System.out.println("返回空");
            }
            System.out.println("-------------------------------------");
            System.out.println("返回数据为:" + ResponseString);
            return ResponseString;
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        } finally {
            try {
                out.close();
                instr.close();
            } catch (Exception ex) {
                return "1";
            }
        }
    }

    public static void main(String[] args) {
        String url = "https://mt.creditcard.cmbc.com.cn/mbank/credit/tripartitle/yxmfActList.json";
        Map<String, String> req = new HashMap<>();
        Map<String, Object> reqData = new HashMap<>();
        req.put("_isThirdLogin","cmbc_zx");
        req.put("params","TUlJRlNBWUtLb0VjejFVR0FRUUNBNkNDQlRnd2dnVTBBZ0VDTVlHZE1JR2FBZ0VDZ0JRUWtLZ0pCYzBndlNkSXVvaWI5VnB1Mml0aDN6QU5CZ2tx\n" +
                "Z1J6UFZRR0NMUU1GQUFSd0tTeVFBa0QzMWo5d280SHRUL1RpdjlaNWZKVWQ1czJKVm5vZE0vbmNSWmYvUE44TnhnNnN2Y2s3am45VENTYmJUc1lX\n" +
                "Y3JHaE9mQnFjVnUrZW02STNXeWJzbkdxeUx4Snl2R0tKZnpqNFgwdW5FWkZUbXJYVVJWbkNNZ3RzL3prd0lLd1hvM2I1TGxOeUxJQXh4b1FhVEND\n" +
                "QkkwR0NpcUJITTlWQmdFRUFnRXdHd1lIS29FY3oxVUJhQVFRMFNMY3pBUEJhM29ydXl4R2RwbEVGSUNDQkdBcE42SGVkUkFOK1JrTFc4VW5vSVR2\n" +
                "WllQdmg4ZWovMkxOMkJyZncxbGJJV3pTYWpwZWJhNjRkYmp5MDllajlOVHZxU3ZBTXl3UEp5RjJoNitJY0IvdU9YSFFmYmdQeEkvMC9GaVJVd0cz\n" +
                "YndKMG5SWC9lY3NEOFRQMWtMcVVUbEh1eVRTU29yRXB1NFg2UXlpU0h4bzdTN2NWR2lEdG5PcnhWMTJUNkJRYTM0NVNxT2ZCQ1RSNUFLWmwzUUpQ\n" +
                "WkY0WlZib3ZRN2ZCZEtETUZRZGtBaDFYN25hWE5yb3lydWJvZXJlejlWSk5uRkZFMzhRWnVnZXN5Y2diMXh6UTQxVThSNUZJQzVQb3JBVVRPa3RS\n" +
                "c3gzUU82Y2lrZ21YcFdSWXFYcVZFL0RiSUh6dDBTaVNJOHU1alRkcGhuTFJKbmQ2M0FSTmZLeFU4Z01KRkFSbGx1OHhLUHU3Z3RsOFc3c1FtUG41\n" +
                "Y0R4NWZyUG5taHBUWk1TTnl2eVU4RU0zVXhYeHVTaGgrZW9LN3I1Yk5tdFIvdlVlNEFJaGxHbkQxekk0Ujg0ZzR4UjdqcUsxY2JDNXR0NHZqaFgy\n" +
                "bnBYZmhBQklHMTVPQWo2ZWpwb3hpOXQzd3J5TUQ3Lzg3ZVdaV0xqNlpoRVNnWHdKeGozQTZzM1h2cWVGYUhTOTFLcTlmR3FkQ3pkVXdFZUptVEZ5\n" +
                "RlZUV1Btam1NaUYyNk14Mm1jbHZhemVJZ25vdkh1MmowcmNEZzhlTm4yZjZwSldPS3NTbnNDYTB5bS9aRWtmTWc1Q1d1VmFuMU9wd3dJSWs0c3pm\n" +
                "ZmVxNVFSOHVkbGhnNHI3eHdGc0RKRW83TnA0Q1U4dzRFOEc2ZGhjK255Q2tRZWl3TS9lU002Y1FLUnBGNmxtdVNuTWNPY0xsK0g5RTRTdEJyMk4z\n" +
                "dWZUdm0rYVpqeE94RWh1cjJyOEJSRFFrTk1JcjNrRDFpUkUvOHdNT1VyK0cvNEhrdm5OeHlqVnpueFhxZEJKOGUyZ3RJZXVLWVIvOXYyY2JGMkVF\n" +
                "QXRTVkgyYnFxVloyU0tGWW4rbzhlM09BbTJlMGp0TU9PYWQ2S2g2ejF5SDRvR2Yrc04zM3hlZDIzNFU0SGNPYjJyVmZsTjU2Z1E3d1Fkemd6S1lr\n" +
                "OFdrSWFHc2tCaldZSDVIREwxQURyWkp3YUxqTThLZnhrQ3RPZU9DVW9Vdk5SbEg2SWxHcis3cWJHcjhxdmhIS0dMNG8yZC9IRjJtaUx6dFo5dzla\n" +
                "Q2VoMlpaUUcrRnJWU0h5NDNNRzU5OXkzQWhPa21lTFVoQmkzL0V3cEY5UUZ3clRYYzZ0bFcvMGY5UUNHa1A1bDYzc1AxdTB5djBwVm05WlFmVXRH\n" +
                "cnJtRXBxZy90Qno0MWVRd05rVHQ0S0hGc0JpQUFraHYzL3ZmRzB3c0VwMlo2NGVHTDNSYVJIL2ZOUUI3MG5lRVFmbVYzVFNGQUV2SmFtWW1ZVTJZ\n" +
                "cWppUTNkT1JncTBuQjFkOG5BZDNHS01pamYzcmF0RHVQOEtSMnZsNW9rQjdBckE2MUM3aGhEZXNRY0FtOXNEdTRBcS9lN3AxNWc4TXI0SUxLOG4z\n" +
                "dEVoSEQ0MzJmMEZsUUdVcWt4Z3MrYzlFT2lwMHJnaGVCY3NKVzBhaXA2bG1Bckd0WHNvdmE0R0p5cmhIbjA0cUtidUJBQjJFVktkTFZLMjU5cWli\n" +
                "RDdjMTJxNmwySkd4ZmpNZ2xjTUIvVkNJWWcrVzFHemQrQjllbW5LT3Y5Vyt5Ui9pdGZSZ05JZTdQdk1IY2lXRTVIb243akx5WC9PTFQrMzBBVUpv\n" +
                "bU5QVUZ1bFJPSHdWTVFtRXh6Y2JVd0RtVEl2U05mOFVHajVkbS9vbXdzUUNZWERva1pTaUU1ZGc2WVJxZ3k0VmszanVmaDRPV3Zub0xKemNZRFZy\n" +
                "eUpFZ0paMmpLcUdMQUVuMFh0bFBQQVkreFlBOHdGdmovTTRFM3hJbzV1bG0=");
        req.put("method","refund");
        reqData.put("cmbcReq",req);
        final String request = JSON.toJSONString(reqData);
        final String status = doHttpPost(request, url);
        System.out.println("-------------------------------------");
        System.out.println(status);
    }
}