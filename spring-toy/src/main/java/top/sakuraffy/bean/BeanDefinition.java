package top.sakuraffy.bean;

import java.util.List;

/**
 * @author Sakuraffy
 * @date 2021/7/7 21:26
 */
public interface BeanDefinition {
    /**
     * get bean id
     * @return
     */
    String getId();

    /**
     * get bean name
     * @return
     */
    String getBeanClassName();

    /**
     * get bean class
     * @return
     */
    Class<?> getBeanClass();

    /**
     * get propertyValues
     * @return
     */
    List<PropertyValue> getPropertyValues();

    /**
     * get bean scope
     * @return
     */
    BeanScope getBeanScope();
}
