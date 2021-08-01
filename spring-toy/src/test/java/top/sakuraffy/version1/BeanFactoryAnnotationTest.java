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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author: zhangqiushi
 * @create: 2021/07/16 16:19
 */
public class BeanFactoryAnnotationTest {
    private Resource resource;
    private DefaultBeanFactory beanFactory;
    private XmlBeanDefinitionReader reader;


    @BeforeEach
    public void setUp() {
        resource = new ClassPathResource("config-v2.xml");
        beanFactory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitionResource(resource);
    }

    @Test
    public void testGetBean() throws BeanDefinitionException {

    }
}
