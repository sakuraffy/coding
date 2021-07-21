package top.sakuraffy.version1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.sakuraffy.data.xml.OrderService;
import top.sakuraffy.data.xml.User;
import top.sakuraffy.data.xml.UserService;
import top.sakuraffy.exception.BeanDefinitionException;
import top.sakuraffy.bean.version2.ClassPathResource;
import top.sakuraffy.bean.version2.DefaultBeanFactory;
import top.sakuraffy.bean.version2.Resource;
import top.sakuraffy.bean.version2.XmlBeanDefinitionReader;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeanFactoryTest {
    private Resource resource;
    private DefaultBeanFactory beanFactory;
    private XmlBeanDefinitionReader reader;


    @BeforeEach
    public void setUp() {
        resource = new ClassPathResource("applicationContext.xml");
        beanFactory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitionResource(resource);
    }

    @Test
    public void testGetBean() throws BeanDefinitionException {
        UserService userService = (UserService) beanFactory.getBean("userService");
        assertTrue(userService.getUser() instanceof User);
        assertEquals("sakuraffy", userService.getUser().getName());
        assertEquals(222, userService.getOrderService().getOrderId());

        OrderService orderService = (OrderService) beanFactory.getBean("orderService");
        assertTrue(orderService.getUserService() instanceof UserService);
        assertEquals(111, orderService.getUserService().getUserId());
    }

    @Test
    public void testGetBeanWithArgument() throws BeanDefinitionException {
        UserService userService1 = (UserService) beanFactory.getBean("userService1");
        assertTrue(userService1 instanceof UserService);
        assertTrue(userService1.getUser() instanceof User);
        assertEquals("sakuraffy", userService1.getUser().getName());
        assertEquals(222, userService1.getOrderService().getOrderId());
        assertEquals(123, userService1.getUserId());
        assertEquals(Arrays.asList("swimming"), userService1.getHobbies());
    }
}
