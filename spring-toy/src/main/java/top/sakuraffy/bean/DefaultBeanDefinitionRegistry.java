package top.sakuraffy.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangqiushi
 * @create: 2021/07/13 12:48
 */
public class DefaultBeanDefinitionRegistry implements BeanDefinitionRegistry {

    private Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {

    }

    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return null;
    }
}
