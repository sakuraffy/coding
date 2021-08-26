package top.sakuraffy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.sakuraffy.data.annotation.Order;
import top.sakuraffy.data.annotation.User;
import top.sakuraffy.service.UserService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author: zhangqiushi
 * @create: 2021/08/02 18:47
 */
public class AppConfigTest {
    private ApplicationContext context;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void testGetBeanByProperty() {
        UserService userService = (UserService) context.getBean(UserService.class);
//        userService.insert(new User());
        userService.getById();
        assertNotNull(userService);
    }
}
