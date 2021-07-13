package top.sakuraffy.version2.bean;

/**
 * @author Sakuraffy
 * @date 2021/7/7 21:20
 */
public interface SingletonBeanRegistry {
    /**
     * registry singleton bean
     * @param name
     * @param object
     */
    void registerSingleton(String name, Object object);

    /**
     * get bean
     * @param name
     * @return
     */
    Object getSingleton(String name);

    /**
     * contain singleton
     * @param name
     * @return
     */
    boolean containsSingleton(String name);
}
