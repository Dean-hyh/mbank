package com.dean.demo.advise;

import com.dean.demo.datasource.DataSource;
import com.dean.demo.datasource.DataSourceContextHolder;
import com.dean.demo.enums.DbankExceptionEnum;
import com.dean.demo.exception.DbankException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * @author Dean
 * @date 2019-10-22
 * 动态数据源切面类
 */
@Slf4j
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
    public void after(JoinPoint point) {
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
            //默认使用类型注解
            if (clazz.isAnnotationPresent(DataSource.class)) {
                DataSource source = clazz.getAnnotation(DataSource.class);
                log.info("AOP使用类型注解获取到的数据源标识:" + source.value() + "执行的方法为:" + clazz.getName() + "." + method.getName());
                DataSourceContextHolder.setDataSource(source.value());
            }
            //方法注解可以覆盖类型注解
            Method m = clazz.getMethod(method.getName(), types);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource source = m.getAnnotation(DataSource.class);
                log.info("AOP使用方法注解获取到的数据源标识:" + source.value() + "---执行的方法为:" + clazz.getName() + "." + method.getName());
                DataSourceContextHolder.setDataSource(source.value());
            }
        } catch (Exception e) {
            log.error(clazz + ":" + e.getMessage());
            throw new DbankException(DbankExceptionEnum.GET_DATASOURCE_IDENTIFICATION_FAILED);
        }
    }
}