package top.sakuraffy.version1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.sakuraffy.data.OrderService;
import top.sakuraffy.data.User;
import top.sakuraffy.data.UserService;
import top.sakuraffy.exception.BeanDefinitionException;
import top.sakuraffy.version1.bean.ClassPathResource;
import top.sakuraffy.version1.bean.DefaultBeanFactory;
import top.sakuraffy.version1.bean.Resource;
import top.sakuraffy.version1.bean.XmlBeanDefinitionReader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
}