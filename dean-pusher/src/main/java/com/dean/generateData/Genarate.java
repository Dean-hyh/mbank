package com.dean.generateData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/22 15:51
 */
public class Genarate {
    private static final String SPLIT = "|";

    public static void main(String[] args) {
        String fileName = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String path = "D:\\idea\\ideaSpace_dynamicDbbank\\dbank\\dbank-pusher\\src\\main\\resources\\data";
        try {
            /* 写入Txt文件 */
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(path + "\\" + fileName + ".txt");
            // 创建新文件
            file.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(file));

            /*造数据*/
            for (int i = 0; i < 10; i++) {
                StringBuilder bd = new StringBuilder();
                //证件类型
                Map<String, String> idType = new HashMap<>();
                String[] idTypeKey = {"01", "03", "12", "13", "14"};
                idType.put("01", "18位身份证");
                idType.put("03", "军官证");
                idType.put("12", "中国护照");
                idType.put("13", "外国护照");
                idType.put("14", "港澳通行证");

                //证件号
                Map<Integer, String> idNo = new HashMap<>();
                idNo.put(1, "42068219920711631X");
                idNo.put(2, "34052419800101001X");
                idNo.put(3, "42068219931008632X");
                //客户类型
                Map<String, String> custType = new HashMap<>();
                String[] custTypeKey = {"02", "03"};
                custType.put("02", "一般高端");
                custType.put("03", "私人管家");

                //卡级
                Map<String, String> cardLevel = new HashMap<>();
                String[] cardLevelKey = {"10", "30", "40", "45"};
                cardLevel.put("10", "普卡");
                cardLevel.put("30", "金卡");
                cardLevel.put("40", "标白");
                cardLevel.put("45", "豪白");

                //拼接
                String content = bd.append(idTypeKey[new Random().nextInt(5)]).append(SPLIT).
                        append(idNo.get(new Random().nextInt(3)+1)).append(SPLIT).
                        append(cardLevelKey[new Random().nextInt(4)]).append(SPLIT).
                        append(custTypeKey[new Random().nextInt(2)]).toString();
                out.write(content);
                out.write("\r\n");
                out.flush();
            }
            out.close();
            System.out.println("数据生成完毕！");
        } catch (Exception e) {
            System.out.println("写入失败！");
        }
    }
}
