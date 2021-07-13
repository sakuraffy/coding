package top.sakuraffy.version1.bean;

import java.util.List;

/**
 * @author Sakuraffy
 * @date 2021/7/7 21:20
 */
public interface BeanFactory {
    /**
     * 获取Bean
     * @param name
     * @return
     */
    Object getBean(String name);

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
