package top.sakuraffy.data.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: zhangqiushi
 * @create: 2021/07/19 20:04
 */
@Component
@Scope("prototype")
@Service
public class Order {

    @Autowired
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
