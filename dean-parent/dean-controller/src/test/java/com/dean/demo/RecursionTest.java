package com.dean.demo;

import lombok.val;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Dean.h
 * @version 1.0 2020/6/11
 */
public class RecursionTest {
    @Test
    public void reTest(){
        boolean result = test("测试数据",1);
        System.out.println("test方法调用结果："+result);
    }

    /**
     * 递归就是自己调用自己，最后把返回值返回给调用者，一层一层返回上去：第一层->第二层->第三层->第四层
     * @param param
     * @param count
     * @return
     */
    public boolean test(String param,Integer count){
        boolean result=false;
        if(count<5){
            System.out.println("第"+ count + "次请求");
            try {
                if(count==1){
                    //result = "第一层递归";
                    System.out.println("第"+ count + "次请求的结果："+result);
                    throw new IOException();
                }else if(count==2){
                    //result = "第二层递归";
                    System.out.println("第"+ count + "次请求的结果："+result);
                    throw new Exception();
                } else if(count==3){
                    //result = "第三层递归";
                    System.out.println("第"+ count + "次请求的结果："+result);
                    throw new IOException();
                }else if(count==4) {
                    //result = true;
                    System.out.println("第"+ count + "次请求的结果："+result);
                    throw new IOException();
                }
                result = true;
            } catch (IOException e) {
                System.out.println("第"+count+"次请求捕获到IOException异常");
                count++;
                return test(param,count);
            } catch (Exception e){
                System.out.println("第"+count+"次请求捕获到Exception异常");
                count++;
                return test(param,count);
            }
        }
        return result;
    }
}
