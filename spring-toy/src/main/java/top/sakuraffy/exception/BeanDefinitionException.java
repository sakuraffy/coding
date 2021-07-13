package top.sakuraffy.exception;

/**
 * @author Sakuraffy
 * @date 2021/7/13 22:33
 */
public class BeanDefinitionException extends BeansException {

    public BeanDefinitionException(String message) {
        super(message);
    }

    public BeanDefinitionException(String message, Throwable cause) {
        super(message, cause);
    }
}
