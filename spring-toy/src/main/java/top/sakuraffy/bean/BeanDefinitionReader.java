package top.sakuraffy.bean;

import top.sakuraffy.exception.BeanDefinitionException;

/**
 * @author Sakuraffy
 * @date 2021/7/7 21:41
 */
public interface BeanDefinitionReader {
    /**
     * 加载bean定义资源
     * @param resource
     */
    void loadBeanDefinitionResource(Resource resource) throws BeanDefinitionException;
}
