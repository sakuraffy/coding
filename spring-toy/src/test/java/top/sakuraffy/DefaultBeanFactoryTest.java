package top.sakuraffy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.sakuraffy.bean.*;

public class DefaultBeanFactoryTest {
    private Resource resource;
    private BeanFactory beanFactory;
    private BeanDefinitionReader reader;


    @BeforeEach
    public void setUp() {
        resource = new ClassPathResource("applicationContext.xml");
        beanFactory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(beanFactory);
    }

    @Test
    public void testGetBean() {
        final Object result = beanFactory.getBean("name");
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
