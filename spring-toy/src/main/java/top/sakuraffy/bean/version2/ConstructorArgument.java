package top.sakuraffy.bean.version2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: zhangqiushi
 * @create: 2021/07/14 13:02
 */
public class ConstructorArgument {
    private final List<ValueHolder> argumentsValues = new LinkedList<>();

    public void addArgumentValue(Object value) {
        this.argumentsValues.add(new ValueHolder(value));
    }

    public void addArgumentValue(Object value, String type) {
        this.argumentsValues.add(new ValueHolder(value, type));
    }

    public void addArgumentValue(ValueHolder valueHolder) {
        this.argumentsValues.add(valueHolder);
    }

    public List<ValueHolder> getArgumentsValues() {
        return this.argumentsValues;
    }

    public int getArgumentCount() {
        return this.argumentsValues.size();
    }

    public boolean isEmpty() {
        return this.argumentsValues.isEmpty();
    }

    public void clear() {
        this.argumentsValues.clear();
    }

    public static class ValueHolder {

        private Object value;
        private String type;
        private String name;

        public ValueHolder(Object value) {
            this.value = value;
        }

        public ValueHolder(Object value, String type) {
            this.value = value;
            this.type = type;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
