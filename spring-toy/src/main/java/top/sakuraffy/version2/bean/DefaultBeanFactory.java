package top.sakuraffy.version2.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangqiushi
 * @create: 2021/07/13 11:51
 */
public class DefaultBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

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
            createBean(name, bd, args);
        }
        return null;
    }

    private Object createBean(String beanName, BeanDefinition bd, Object[] args) {
        final Object bean = createBeanInstance();
        boolean earlySingletonExposure = bd.isSingleton() && this.allowCircularReferences
                && isSingletonsCurrentlyInCreation(beanName);
        if (earlySingletonExposure) {
            this.addSingletonFactory(beanName, new ObjectFactory<Object>() {
                @Override
                public Object getObject() {
                    return bean;
                }
            });
        }
        return null;
    }

    private Object createBeanInstance() {
        return null;
    }

}
