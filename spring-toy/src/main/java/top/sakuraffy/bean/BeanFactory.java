package top.sakuraffy.bean;

import java.util.List;

/**
 * @author Sakuraffy
 * @date 2021/7/7 21:20
 */
public interface BeanFactory {
    /**
     * 获取Bean
     * @param beanId
     * @return
     */
    Object getBean(String beanId);

    /**
     * 获取Bean
     * @param clazz
     * @return
     */
    Object getBean(Class<?> clazz);


    /**
     * 通过类型获取Bean
     * @param type
     * @return
     */
    List<Object> getBeansByType(Class<?> type);
}
