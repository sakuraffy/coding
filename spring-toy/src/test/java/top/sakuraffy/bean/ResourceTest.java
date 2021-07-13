package top.sakuraffy.bean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import top.sakuraffy.exception.BeanDefinitionException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Sakuraffy
 * @date 2021/7/8 22:30
 */
public class ResourceTest {

    @Test
    public void testClassPathResource() throws IOException{
        final Resource resource1 = new ClassPathResource("applicationContext.xml");
        assertNotNull(resource1);
        assertNotNull(resource1.getInputStream());
    }
}
