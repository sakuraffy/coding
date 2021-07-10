package top.sakuraffy.bean;

/**
 * @author
 * @author Sakuraffy
 * @date 2021/7/7 21:26
 */
public interface BeanDefinition {
    /**
     * get bean id
     * @return
     */
    String getId();

    /**
     * get bean name
     * @return
     */
    String getBeanClassName();
}
