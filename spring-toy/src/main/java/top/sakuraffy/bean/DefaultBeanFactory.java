package top.sakuraffy.bean;

import org.apache.commons.beanutils.BeanUtils;
import top.sakuraffy.exception.BeanCreationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sakuraffy
 * @date 2021/7/7 21:23
 */
public class DefaultBeanFactory implements BeanFactory, BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>(256);

    /**
     * 获取Bean
     * @param beanId
     * @return
     */
    @Override
    public Object getBean(String beanId) {
        BeanDefinition bd = getBeanDefinition(beanId);
        Object bean = instanceBean(bd);
        populateBean(bd, bean);
        return bean;
    }

    @Override
    public Object getBean(Class<?> clazz) {
        return null;
    }

    @Override
    public List<Object> getBeansByType(Class<?> type) {
        return null;
    }

    /**
     * 填充Bean
     * @param bd
     * @param bean
     */
    private void populateBean(BeanDefinition bd, Object bean) {
        List<PropertyValue> propertyValues = bd.getPropertyValues();
        if (propertyValues == null || propertyValues.isEmpty()) {
            return;
        }
        BeanDefinitionResolver resolver = new BeanDefinitionResolver(this);
        try {
            for (PropertyValue propertyValue : propertyValues) {
                String propertyName = propertyValue.getName();
                Object originalValue = propertyValue.getValue();
                Object resolvedValue = resolver.resolveValueIfNecessary(originalValue);

                BeanUtils.copyProperty(bean, propertyName, resolvedValue);
            }
        } catch (Exception e) {
            throw new BeanCreationException("Failed to obtain BeanInfo for class [" + bd.getBeanClassName() + "]");
        }
    }

    /**
     * 实例Bean
     * @param bd
     * @return
     */
    private Object instanceBean(BeanDefinition bd) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        String beanClassName = bd.getBeanClassName();
        try {
            Class clazz = classLoader.loadClass(beanClassName);
            return clazz.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new BeanCreationException("Created bean for " + beanClassName + " fail.", e);
        }
    }

    /**
     * 注册Bean定义
     *
     * @param beanId
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String beanId, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanId, beanDefinition);
    }

    /**
     * 获取Bean定义
     *
     * @param beanId
     * @return
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        BeanDefinition bd = beanDefinitionMap.get(beanId);
        if (bd == null) {
            throw new BeanCreationException("BeanDefinition does not exists, beanId:" + beanId);
        }
        return bd;
    }
}
