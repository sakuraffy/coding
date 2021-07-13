package top.sakuraffy.version1.bean;

import org.apache.commons.beanutils.BeanUtils;
import top.sakuraffy.exception.BeanCreationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangqiushi
 * @create: 2021/07/13 11:51
 */
public class DefaultBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory, BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>(256);
    private boolean allowCircularReferences = true;

    @Override
    public Object getBean(String name) {
        return doGetBean(name, null, null);
    }

    @Override
    public Object getBean(Class<?> type) {
        return doGetBean(null, type, null);
    }

    @Override
    public List<Object> getBeansByType(Class<?> type) {
        return null;
    }

    private Object doGetBean(String name, Class<?> type, Object[] args) {
        Object singleton = this.getSingleton(name);
        if (singleton == null) {
            BeanDefinition bd = beanDefinitionMap.get(name);
            singleton = createBean(name, bd, args);
        }
        return singleton;
    }

    private Object createBean(String beanName, BeanDefinition bd, Object[] args) {
        final Object bean = createBeanInstance(bd);
        this.earlySingletonObjects.put(beanName, bean);
        populateBean(bd, bean);
        this.earlySingletonObjects.remove(beanName);
        this.singletonObjects.put(beanName, bean);
        return bean;
    }

    private Object createBeanInstance(BeanDefinition bd) {
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

    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return beanDefinitionMap.get(name);
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
