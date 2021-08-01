package top.sakuraffy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.sakuraffy.data.annotation.Order;
import top.sakuraffy.data.annotation.User;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author: zhangqiushi
 * @create: 2021/07/15 16:31
 */
public class AnnotationTest {
    private ApplicationContext context;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext("top.sakuraffy");
    }

    @Test
    public void testGetBeanByProperty() {
        User user = (User) context.getBean("user");
        assertNotNull(user);
        assertNotNull(user.getOrder());
        Order order = (Order) context.getBean("order");
        assertNotNull(order);
        assertNotNull(order.getUser());
    }
}
