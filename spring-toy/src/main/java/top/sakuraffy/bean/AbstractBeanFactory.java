package top.sakuraffy.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangqiushi
 * @create: 2021/07/13 11:51
 */
public class AbstractBeanFactory implements BeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>(256);

    @Override
    public Object getBean(String beanId) {
        return doGetBean(beanId, null, null);
    }

    @Override
    public Object getBean(Class<?> type) {
        return doGetBean(null, type, null);
    }

    @Override
    public List<Object> getBeansByType(Class<?> type) {
        return null;
    }

    private Object doGetBean(String beanId, Class<?> type, Object[] args) {
        return null;
    }
}
