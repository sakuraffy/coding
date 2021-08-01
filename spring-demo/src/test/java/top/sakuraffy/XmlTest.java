package top.sakuraffy;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import top.sakuraffy.data.xml.User;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author: zhangqiushi
 * @create: 2021/07/15 16:31
 */
public class XmlTest {

    private BeanFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
    }

    @Test
    public void testGetBeanByProperty() {
        assertTrue(factory.getBean("user") instanceof User);
    }
}
