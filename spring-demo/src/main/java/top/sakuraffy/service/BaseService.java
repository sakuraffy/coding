package top.sakuraffy.service;

/**
 * @author: zhangqiushi
 * @create: 2021/08/02 18:41
 */
public interface BaseService<T> {
    /**
     * insert
     * @param t
     */
    void insert(T t);

    /**
     * update
     * @param t
     */
    void update(T t);
}
