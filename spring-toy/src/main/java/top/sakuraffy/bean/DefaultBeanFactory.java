package top.sakuraffy.bean;

import top.sakuraffy.bean.BeanFactory;

/**
 * @author Sakuraffy
 * @date 2021/7/7 21:23
 */
public class DefaultBeanFactory implements BeanFactory {

    private BeanDefinitionRegistry registry;

    /**
     * 获取Bean
     * @param name
     * @return
     */
    @Override
    public Object getBean(String name) {
        return null;
    }
}
