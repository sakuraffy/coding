package top.sakuraffy.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sakuraffy
 * @date 2021/7/7 21:15
 */
public class GenericBeanDefinition implements BeanDefinition {
    private String id;
    private String beanClassName;
    private BeanScope scope;
    private Class beanClass;

    BeanF

    List<PropertyValue> propertyValues = new ArrayList<>();

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBeanClassName() {
        return beanClassName;
    }

    @Override
    public Class<?> getBeanClass() {
        return beanClass;
    }

    @Override
    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    @Override
    public BeanScope getBeanScope() {
        return scope;
    }
}
