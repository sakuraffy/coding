package top.sakuraffy.data;

/**
 * @author Sakuraffy
 * @date 2021/7/8 22:40
 */
public class UserService {
    private User user;
    private OrderService orderService;
    private int userId;

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
}
