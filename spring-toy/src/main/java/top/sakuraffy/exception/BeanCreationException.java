package top.sakuraffy.exception;

/**
 * @author Sakuraffy
 * @date 2021/7/13 22:40
 */
public class BeanCreationException extends BeansException {

    public BeanCreationException(String message) {
        super(message);
    }

    public BeanCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
