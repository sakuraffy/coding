package top.sakuraffy.bean;

/**
 * @author
 * @author Sakuraffy
 * @date 2021/7/7 21:26
 */
interface BeanDefinition {
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
