package com.ms.generateData;

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
public class GenarateUserList {
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
            file = new File(path + "\\" + "empList_" + fileName + ".txt");
            // 创建新文件
            file.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(file));

            /*造数据*/
            for (int i = 0; i < 100; i++) {
                String chineseName = RandomValueUtil.getChineseName();
                out.write(chineseName);
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
