package top.sakuraffy.version1.bean;

/**
 * @author Sakuraffy
 * @date 2021/7/13 22:35
 */
public interface BeanDefinitionReader {
    /**
     * 加载bean定义资源
     * @param resource
     */
    void loadBeanDefinitionResource(Resource resource);
}
