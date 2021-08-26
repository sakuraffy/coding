package top.sakuraffy.annotation;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author: zhangqiushi
 * @create: 2021/08/02 19:09
 */
@Target({ElementType.METHOD,ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@BaseAnnotation
public @interface LogAnnotation {

}
