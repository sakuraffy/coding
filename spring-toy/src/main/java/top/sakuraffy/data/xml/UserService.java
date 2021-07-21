package top.sakuraffy.data.xml;

import java.util.List;

/**
 * @author Sakuraffy
 * @date 2021/7/8 22:40
 */
public class UserService {
    private User user;
    private OrderService orderService;
    private int userId;
    private List<String> hobbies;

    public UserService() {
    }

    public UserService(User user, OrderService orderService, int userId, List<String> hobbies) {
        this.user = user;
        this.orderService = orderService;
        this.userId = userId;
        this.hobbies = hobbies;
    }

    public UserService(User user, OrderService orderService, int userId) {

    }

    public UserService(User user, int userId, List<String> hobbies) {

    }

    public UserService(User user, int userId, OrderService orderService) {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
