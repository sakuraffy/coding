package top.sakuraffy.bean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.sakuraffy.data.User;
import top.sakuraffy.exception.BeanDefinitionException;
import top.sakuraffy.data.UserService;

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
        BeanDefinition bd = beanFactory.getBeanDefinition("user");
        assertEquals("top.sakuraffy.data.User", bd.getBeanClassName());

        User user = (User) beanFactory.getBean("user");
        assertTrue(user instanceof User);
        assertEquals("sakuraffy", user.getName());
    }

    @Test
    public void testGetBeanWithInvalidBean() {
        UserService userService = (UserService) beanFactory.getBean("userService");
        assertTrue(userService.getUser() instanceof User);
        assertEquals("sakuraffy", userService.getUser().getName());
    }
}
