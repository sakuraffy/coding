package top.sakuraffy.bean.version1;

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
     * is singleton
     * @return
     */
    boolean isSingleton();

    /**
     * is prototype
     * @return
     */
    boolean isPrototype();

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

    /**
     * get constructor argument
     * @return
     */
    ConstructorArgument getConstructorArgument();
}
