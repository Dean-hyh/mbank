package com.ms.credit;

import com.ms.credit.utils.LocalObjectUtils;
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
}
