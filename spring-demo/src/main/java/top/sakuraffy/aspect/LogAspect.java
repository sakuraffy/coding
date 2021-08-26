package top.sakuraffy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import top.sakuraffy.annotation.BaseAnnotation;
import top.sakuraffy.annotation.LogAnnotation;

import java.lang.annotation.Annotation;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhangqiushi
 * @create: 2021/08/02 19:06
 */
@Aspect
@Component
public class LogAspect {

//    @Pointcut("@annotation(top.sakuraffy.annotation.LogAnnotation)")
    @Pointcut("execution ( * top.sakuraffy.service.impl..*(..))")
    public void pointcut(){

    }

    @Around("pointcut()")
    public void around(JoinPoint joinPoint) throws Throwable {
        System.out.println("this is before around advice");
        LogAnnotation annotation = getLogAnnotation(joinPoint);
//        joinPoint.proceed();
        System.out.println("this is after around advice");
    }


    /**
     * 根据类或方法获取数据源注解
     */
    private LogAnnotation getLogAnnotation(JoinPoint joinPoint){
        try {
            //getSignature会找到增强方法及类，如果是使用了BaseMapper里的父类方法，这里获取到的是BaseMapper，导致没有注解，无法指定数据源
            Class<?> targetClass = joinPoint.getSignature().getDeclaringType();
            Annotation[] annotations = targetClass.getAnnotations();
            LogAnnotation dataSourceAnnotation = targetClass.getAnnotation(LogAnnotation.class);
            // 先判断类的注解
            if(null != dataSourceAnnotation){
//                return dataSourceAnnotation;
            }

            //再判断方法上有没有注解
            MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
            dataSourceAnnotation = methodSignature.getMethod().getAnnotation(LogAnnotation.class);
            AnnotationUtils.findAnnotation(methodSignature.getMethod(), BaseAnnotation.class);
            if(null != dataSourceAnnotation){
//                return dataSourceAnnotation;
            }

            //getTarget会找到目标方法及类，解决了之前方式的弊端，考虑到遍历及兼容的问题，优先上面的方法
            Class<?>[] interfaces = joinPoint.getTarget().getClass().getInterfaces();
            if( null!= interfaces){
                for (Class<?> c : interfaces){
                    dataSourceAnnotation = c.getAnnotation(LogAnnotation.class);
                    if(null != dataSourceAnnotation){
                        return dataSourceAnnotation;
                    }
                }
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }
}
