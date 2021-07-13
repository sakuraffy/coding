package top.sakuraffy.data;

/**
 * @author Sakuraffy
 * @date 2021/7/13 23:16
 */
public class OrderService {
    private UserService userService;
    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
