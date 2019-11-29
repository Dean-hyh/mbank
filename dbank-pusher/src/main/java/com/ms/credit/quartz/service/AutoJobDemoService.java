package com.ms.credit.quartz.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/22 13:43
 */
@Service
public class AutoJobDemoService {

    Map<String,String> map = new HashMap<>();
    public void execute(String fileName) {
        String file = new StringBuffer().append(fileName).append(".txt").toString();
        System.out.println(file);
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\idea\\ideaSpace_dynamicDbbank\\dbank\\dbank-parent\\dbank-quartz\\src\\main\\resources\\data\\"+file));
            String str = null;
            while ((str = br.readLine()) != null) {
                String[] split = str.split("\\|");
                map.put(split[1],str);
            }
        } catch (Exception e) {
            System.out.println("读取失败！");
        }
        System.out.println(map);
    }
}
