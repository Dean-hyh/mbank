/*

package com.cmbcc.credit.advise;

import com.cmbcc.credit.utils.DataSource;
import com.cmbcc.credit.utils.DataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

*/
/**
 * @author Dean
 * @version 1.0
 * @date 2019/10/23 17:50
 *//*



@Aspect
@Component
public class AroundAdvise {

*/
/**
     * 织入
     * @param pjp
     * @return
     * @throws Throwable
     *//*


    @Around("execution(* com.ms.credit.dao.*.*(..))")
    public Object changeDb(ProceedingJoinPoint pjp) throws Throwable {
        //获取要执行的方法的签名+注解信息
        Signature signature = pjp.getSignature();
        //强转为方法签名
        MethodSignature methodSignature = (MethodSignature) signature;
        //获得方法（反射）
        Method method = methodSignature.getMethod();
        //获得方法名
        String methodName = method.getName();
        System.out.println("执行的方法："+ methodName);
        //方法签名（注解中的value）
        //判断方法中是否有注解
        if (method.isAnnotationPresent(DataSource.class)) {
            //有注解
            DataSource annotation = method.getAnnotation(DataSource.class);
            String dbType = annotation.value();
            DataSourceContextHolder.setDataSource(dbType);
        }
        return pjp.proceed();
    }
}
*/
