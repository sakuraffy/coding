package top.sakuraffy.bean.version1;

/**
 * @author: zhangqiushi
 * @create: 2021/07/13 10:18
 */
public enum BeanScope {
    DEFAULT("singleton"),

    SINGLETON("singleton"),

    PROTOTYPE("prototype");

    private String name;

    BeanScope(String name) {
        this.name = name;
    }

    public static BeanScope of(String name) {
        for (BeanScope scope : values()) {
            if (scope.getName().equals(name)) {
                return scope;
            }
        }
        throw new IllegalArgumentException("bean scope [" + name + "] not defined");
    }

    public boolean isPrototype() {
        return "prototype".equals(this.name);
    }

    public boolean isSingleton() {
        return "singleton".equals(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
