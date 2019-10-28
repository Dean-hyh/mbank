package com.ms.credit.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @auther Dean
 * @Date 2019-10-22
 * 人民币金额大小写转换
 */
public class MoneyConvertUtil {
    /**
     * 汉字金额
     */
    private static final String[] CN_NUM_TAB = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    /**
     * 整数单位
     */
    private static final String[] INTEGER_UNIT_TAB = {"", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟"};
    /**
     * 小数单位
     */
    private static final String[] DECIMAL_UNIT_TAB = {"角", "分", "厘"};

    public static void main(String[] args) {
        System.out.println("请输入金额：");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = in.readLine();
            String[] strArr = str.split("\\.");
            char[] chNumArrInteger = strArr[0].toCharArray();
            String[] convertIntegerNum = convertUpper(chNumArrInteger);
            StringBuilder container = new StringBuilder("圆整");
            for (int x = convertIntegerNum.length - 1, y = 0; x >= 0; x--, y++) {
                String num = convertIntegerNum[x];
                if (num.equals("零")) {
                    if (y == 4 || y == 8) {
                        container.insert(0, num + INTEGER_UNIT_TAB[y]);
                    } else {
                        container.insert(0, num);
                    }
                } else {
                    container.insert(0, num + INTEGER_UNIT_TAB[y]);
                }
            }
            if (strArr.length == 2) {
                int len = container.length();
                container.replace(len - 2, len, "圆");
                char[] chNumArrDecimal = strArr[1].toCharArray();
                String[] convertDecimalNum = convertUpper(chNumArrDecimal);
                for (int x = 0; x < convertDecimalNum.length; x++) {
                    container.append(convertDecimalNum[x] + DECIMAL_UNIT_TAB[x]);
                }
            }
            String put = container.toString();
            put = put.replaceAll("佰零+万", "佰万");
            put = put.replaceAll("佰零+亿", "佰亿");
            put = put.replaceAll("仟零+万", "仟万");
            put = put.replaceAll("仟零+亿", "仟亿");
            put = put.replaceAll("零+", "零");
            put = put.replaceAll("零万", "万");
            put = put.replaceAll("零万零", "零");
            put = put.replaceAll("拾零", "拾");
            put = put.replaceAll("零圆", "圆");
            System.out.println("该金额的大写形式为：" + put);

        } catch (NumberFormatException e) {
            System.out.println("输入错误，请输入有效的金额数字");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String[] convertUpper(char[] arr) {
        String[] convertNum = new String[arr.length];
        for (int x = 0; x < arr.length; x++) {
            int num = Integer.parseInt(arr[x] + "");
            convertNum[x] = CN_NUM_TAB[num];
        }
        return convertNum;
    }
}