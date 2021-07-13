package top.sakuraffy.version1;

import org.junit.jupiter.api.Test;
import top.sakuraffy.data.User;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SpringIOCTest {

    private SpringIoc springIoc;

    @Test
    public void testGetBean() throws Exception {
        springIoc = new SpringIoc();
        springIoc.loadBeanDefinitionResource("applicationContext.xml");
        User user = (User) springIoc.getBean("user");
        assertTrue(user instanceof User);
        assertEquals("sakuraffy", user.getName());
    }
}
