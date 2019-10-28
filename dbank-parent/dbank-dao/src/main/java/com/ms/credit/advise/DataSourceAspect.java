package com.ms.credit.advise;

import com.ms.credit.datasource.DataSource;
import com.ms.credit.datasource.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Dean
 * @date 2019-10-22
 * 动态数据源切面类
 */
@Component
public class DataSourceAspect {
    /**
     * 拦截目标方法，获取由@DataSource指定的数据源标识，设置到线程局部表变量中以便切换数据源
     *
     * @param point
     * @throws Exception
     */
    public void before(JoinPoint point) throws Exception {
        Class<?> target = point.getTarget().getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        // 默认使用目标类型的注解，如果没有则使用其实现接口的注解
        for (Class<?> clazz : target.getInterfaces()) {
            resolveDataSource(clazz, signature.getMethod());
        }
        resolveDataSource(target, signature.getMethod());
    }

    /**
     * 清理threadLocal
     * @param point
     */
    public void after(JoinPoint point){
        DataSourceContextHolder.clearDataSource();
    }

    /**
     * 提取目标对象方法注解和类型注解中的数据源标识
     *
     * @param
     * @param
     */
    private void resolveDataSource(Class<?> clazz, Method method) {
        try {
            Class<?>[] types = method.getParameterTypes();
            // 默认使用类型注解
            if (clazz.isAnnotationPresent(DataSource.class)) {
                DataSource source = clazz.getAnnotation(DataSource.class);
                DataSourceContextHolder.setDataSource(source.value());
            }
            // 方法注解可以覆盖类型注解
            Method m = clazz.getMethod(method.getName(), types);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource source = m.getAnnotation(DataSource.class);
                DataSourceContextHolder.setDataSource(source.value());
            }
        } catch (Exception e) {
            System.out.println(clazz + ":" + e.getMessage());
        }
    }
}