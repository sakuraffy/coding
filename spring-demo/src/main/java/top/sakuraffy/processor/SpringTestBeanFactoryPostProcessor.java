package top.sakuraffy.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author: zhangqiushi
 * @create: 2021/07/19 18:16
 */
@Component
public class SpringTestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public SpringTestBeanFactoryPostProcessor() {
        System.out.println("init");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("action");
    }
}
