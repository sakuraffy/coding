package top.sakuraffy.exception;

/**
 * @author
 * @author Sakuraffy
 * @date 2021/7/7 23:06
 */
public class BeanDefinitionException extends Throwable {

    public BeanDefinitionException(String message) {
        super(message);
    }

    public BeanDefinitionException(String message, Throwable cause ) {
        super(message, cause);
    }
}
