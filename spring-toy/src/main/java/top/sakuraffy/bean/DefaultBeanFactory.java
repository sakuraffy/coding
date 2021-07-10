package top.sakuraffy.bean;

import org.apache.commons.lang.StringUtils;
import top.sakuraffy.exception.BeanCreationException;

import java.util.HashMap;
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
        if (bd == null) {
            throw new BeanCreationException("BeanDefinition does not exists, beanId:" + beanId);
        }
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
        return beanDefinitionMap.get(beanId);
    }
}
