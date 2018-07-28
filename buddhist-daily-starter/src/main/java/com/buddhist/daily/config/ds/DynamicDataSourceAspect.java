package com.buddhist.daily.config.ds;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by wangyulin on 25/11/2017.
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(com.buddhist.daily.config.ds.DS)")
    public void beforeSwitchDS(JoinPoint point){

        Class<?> className = point.getTarget().getClass();

        String methodName = point.getSignature().getName();
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        try {
            Method method = className.getMethod(methodName, argClass);

            if (method.isAnnotationPresent(DS.class)) {
                DS annotation = method.getAnnotation(DS.class);
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        DataSourceContextHolder.setDB(dataSource);
    }


    @After("@annotation(com.buddhist.daily.config.ds.DS)")
    public void afterSwitchDS(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }
}
