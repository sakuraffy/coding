package top.sakuraffy.bean;

/**
 * @author: zhangqiushi
 * @create: 2021/07/10 19:53
 */
public class BeanDefinitionResolver {
    private final BeanFactory beanFactory;

    public BeanDefinitionResolver(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }


    public Object resolveValueIfNecessary(Object value) {
        if (value instanceof RuntimeBeanReference) {
            RuntimeBeanReference ref = (RuntimeBeanReference) value;
            String refName = ref.getBeanName();
            return this.beanFactory.getBean(refName);
        } else if (value instanceof TypedStringValue) {
            TypedStringValue stringValue = (TypedStringValue) value;
            return stringValue.getValue();
        } else {
            return value;
        }
    }
}
