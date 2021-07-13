package top.sakuraffy.version2.bean;

/**
 * @program: coding
 * @description: 属性值
 * @author: zhangqiushi
 * @create: 2021/07/10 18:19
 */
public class PropertyValue {
    private String name;
    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
