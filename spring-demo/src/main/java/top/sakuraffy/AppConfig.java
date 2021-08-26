package top.sakuraffy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: zhangqiushi
 * @create: 2021/08/02 18:39
 */

@Configuration
@ComponentScan({"top.sakuraffy"})
@EnableAspectJAutoProxy
public class AppConfig {

}
