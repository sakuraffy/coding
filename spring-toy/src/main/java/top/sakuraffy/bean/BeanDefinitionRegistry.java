package top.sakuraffy.bean;

/**
 * @author Sakuraffy
 * @date 2021/7/7 22:49
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册Bean定义
     * @param beanId
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanId, BeanDefinition beanDefinition);

    /**
     * 获取Bean定义
     * @param beanId
     * @return
     */
    BeanDefinition getBeanDefinition(String beanId);
}
