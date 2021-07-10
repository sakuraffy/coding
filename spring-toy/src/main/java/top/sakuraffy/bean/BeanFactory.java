package top.sakuraffy.bean;

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
}
