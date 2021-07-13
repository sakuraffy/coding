package top.sakuraffy.bean;

/**
 * @author: zhangqiushi
 * @create: 2021/07/10 19:01
 */
public class RuntimeBeanReference {
    private String beanName;

    public RuntimeBeanReference(String refName) {
        this.beanName = refName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
