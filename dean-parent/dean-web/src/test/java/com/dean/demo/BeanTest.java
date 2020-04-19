package com.dean.demo;

import com.dean.demo.utils.LocalObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;


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
}
