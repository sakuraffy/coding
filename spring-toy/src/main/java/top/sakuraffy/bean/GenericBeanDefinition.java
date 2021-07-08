package top.sakuraffy.bean;

import top.sakuraffy.bean.BeanDefinitionRegistry;

/**
 * @author Sakuraffy
 * @date 2021/7/7 21:15
 */
public class GenericBeanDefinition implements BeanDefinition {
    private String id;
    private String beanClassName;

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    /**
     * get bean id
     * @return
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * get bean name
     *
     * @return
     */
    @Override
    public String getBeanClassName() {
        return beanClassName;
    }
}
