package top.sakuraffy.bean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    }

    @Test
    public void testGetBean() throws BeanDefinitionException {
        reader.loadBeanDefinitionResource(resource);
        BeanDefinition bd = beanFactory.getBeanDefinition("userService");

        assertEquals("top.sakuraffy.data.UserService", bd.getBeanClassName());
        UserService orderService = (UserService) beanFactory.getBean("userService");
        assertTrue(orderService instanceof UserService);
    }

    @Test
    public void testGetBeanWithInvalidBean() {
        final Object result = beanFactory.getBean("name");
    }

    @Test
    public void testGetBeanWithInvalidResource() {
        final Object result = beanFactory.getBean("name");
    }
}
