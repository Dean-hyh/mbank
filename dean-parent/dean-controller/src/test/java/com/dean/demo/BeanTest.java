package com.dean.demo;

import com.dean.demo.enums.DbankExceptionEnum;
import com.dean.demo.exception.DbankException;
import com.dean.demo.service.utils.DreamResultParseUtil;
import com.dean.demo.utils.LocalObjectUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author Dean
 * @version 1.0
 * @date 2019/12/18 10:54
 */
public class BeanTest {
    @Test
    public void isEmpty(){
        Stu stu = new Stu();
        boolean b = LocalObjectUtils.allFieldIsNull(stu);
        System.out.println(b);
        System.out.println(stu.toString());
        System.out.println(String.valueOf(stu));
        System.out.println(StringUtils.isNotBlank(stu.toString()));

        boolean empty = StringUtils.isEmpty("");
        System.out.println(empty);
    }

    @Test
    public void isNull(){
        try {
            Class<?>[] interfaces = null;
            System.out.println(interfaces.length);
        }catch (Exception e){
            System.out.print("出现异常啦,异常原因：");
            if("NullPointerException".equals(e.toString().substring(e.toString().lastIndexOf(".",e.toString().length())+1))){
                System.out.println("空指针");
            }
        }
    }

    @Test
    public void dateTest() throws ParseException {
        String dateStr = "20200511";
        Date parse = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
        String format = new SimpleDateFormat("yyyy/MM/dd").format(parse);
        System.out.println(format);
    }

    @Test
    public void jsonTest() throws ParseException {
        Map<String,Object> reMap = new HashMap<>();
        Map<String,Object> resultMap = new HashMap<>();
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("date","20200504");
        map1.put("time","12110101");
        map1.put("desc","充话费");
        map1.put("value","100");
        map1.put("serNo","1001");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("date","20200508");
        map2.put("time","12110101");
        map2.put("desc","签到");
        map2.put("value","100");
        map2.put("serNo","1002");
        Map<String,Object> map3 = new HashMap<>();
        map3.put("date","20200511");
        map3.put("time","12110101");
        map3.put("desc","兑换");
        map3.put("value","-300");
        map3.put("serNo","1003");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        resultMap.put("list",list);
        resultMap.put("dreamValueNo","123123113122414514");
        reMap.put("result",resultMap);
        reMap.put("status",1010);
        //reMap.put("statuMsg","成功");

        System.out.println(reMap);
        String jsonSrt = JSONObject.fromObject(reMap).toString();
        System.out.println("=============================");
        System.out.println(jsonSrt);
        Map<String, Object> map = DreamResultParseUtil.jsonStrToMap(jsonSrt);
        System.out.println("=============================");
        System.out.println(map);
        System.out.println("=============================");
        List<Map<String, Object>> recordList = DreamResultParseUtil.getList(jsonSrt);
        System.out.println(recordList);

        System.out.println("获取梦想记录列表失败："+DreamResultParseUtil.getCodeAndMsg(jsonSrt));
    }

    @Test
    public void dayTest(){
        final String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
        System.out.println(today);

        int days = 1;

        Calendar c = new GregorianCalendar();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_YEAR,-days);
        final String beginDay = new SimpleDateFormat("yyyyMMdd").format(c.getTime());
        System.out.println(beginDay);

    }

    @Test
    public void dgTest(){
        try {
            this.dgT("测试", 3);
        }catch (Exception e){
            System.out.println("异常");
            e.printStackTrace();
        }
    }

    public void dgT(String str,int count) throws Exception {
        if (count > 0) {
            try {
                System.out.println(str + count);
                int a = 1 / 0;
            } catch (Exception e) {
                count--;
                dgT(str, count);
                if(count==0){
                    throw new DbankException(DbankExceptionEnum.FILE_CONTENT_IS_EMPTY);
                }
            }
        }
    }

    @Test
    public void jsonTest1() {
        Map<String,Object> reMap = new HashMap<>();
        List<Map<String,Object>> result = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("dream_acct_type","01");
        map1.put("dream_acct_no","102202005090000000");
        map1.put("tx_time","10211202");
        map1.put("oper_type","01");
        map1.put("flow_no","20200501010123456781");
        map1.put("insert_time","2020050310031202");
        map1.put("tx_date","20200501");
        map1.put("dream_val","100");
        map1.put("tx_seq_no","2020050400101010000000000000002");
        map1.put("tx_date_time","2020050310031202");
        map1.put("tx_desc","充话费");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("dream_acct_type","01");
        map2.put("dream_acct_no","102202005090000000");
        map2.put("tx_time","10211202");
        map2.put("oper_type","01");
        map2.put("flow_no","20200501010123456781");
        map2.put("insert_time","2020050310031202");
        map2.put("tx_date","20200501");
        map2.put("dream_val","-200");
        map2.put("tx_seq_no","2020050400101010000000000000002");
        map2.put("tx_date_time","2020050310031202");
        map2.put("tx_desc","兑换");
        Map<String,Object> map3 = new HashMap<>();
        map3.put("dream_acct_type","01");
        map3.put("dream_acct_no","102202005090000000");
        map3.put("tx_time","10211202");
        map3.put("oper_type","01");
        map3.put("flow_no","20200501010123456781");
        map3.put("insert_time","2020050310031202");
        map3.put("tx_date","20200501");
        map3.put("dream_val","100");
        map3.put("tx_seq_no","2020050400101010000000000000002");
        map3.put("tx_date_time","2020050310031202");
        map3.put("tx_desc","签到");
        result.add(map1);
        result.add(map2);
        result.add(map3);
        reMap.put("result",result);
        reMap.put("status",1010);
        reMap.put("statuMsg","成功");
        Map<String, Object> resultStatistics = new HashMap<>();
        resultStatistics.put("totalSize","5");
        reMap.put("resultStatistics",resultStatistics);
        System.out.println(JSONObject.fromObject(reMap).toString());

        try {
            final Map<String, Object> list2 = DreamResultParseUtil.getMap(reMap);
            System.out.println(list2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ddd(){
        Map<String, Object> map = new HashMap<>();
        System.out.println(map.get("re"));
        List<Object> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        map.put("list2",list);
        Object obj = map.get("list2");
        System.out.println(obj);
        System.out.println((List)obj);
    }

    @Test
    public void time(){
        String str = new SimpleDateFormat("HHmmssSSS").format(new Date());
        String str2 = new SimpleDateFormat("HHmmssF").format(new Date());
        //String str3 = new SimpleDateFormat("HHmmss").format(new Date());
        System.out.println(str);
        System.out.println(str2);
        //System.out.println(str3);

       Map<Object, Object> map = new HashMap<>();
        System.out.println(map.get("12") + "");
    }
}
