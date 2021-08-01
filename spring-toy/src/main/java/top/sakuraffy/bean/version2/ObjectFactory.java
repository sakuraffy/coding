package top.sakuraffy.bean.version2;

/**
 * @author Sakuraffy
 * @date 2021/7/13 13:20
 */
public interface ObjectFactory<T> {
    /**
     * get object
     * @return
     */
    T getObject();
}
