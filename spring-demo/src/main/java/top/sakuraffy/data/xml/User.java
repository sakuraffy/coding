package top.sakuraffy.data.xml;

/**
 * @author: zhangqiushi
 * @create: 2021/07/15 16:29
 */
public class User {
    private int age;
    private String name;

    public User() {
        System.out.println("hello");
    }

    public User(int age, String name) {
        System.out.println(age + name);
        this.age = age;
        this.name = name;
    }
}
