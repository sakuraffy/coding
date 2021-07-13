package top.sakuraffy.bean;

/**
 * @author Sakuraffy
 * @date 2021/7/13 22:43
 */
public interface BeanDefinitionRegistry {

    /**
     * get bean definition
     * @param name
     * @return
     */
    BeanDefinition getBeanDefinition(String name);

    /**
     * registry bean definition
     * @param name
     * @param beanDefinition
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
