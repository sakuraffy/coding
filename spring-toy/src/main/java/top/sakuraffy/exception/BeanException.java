package top.sakuraffy.exception;

/**
 * @author Sakuraffy
 * @date 2021/7/8 22:53
 */
public class BeanException extends RuntimeException {

    public BeanException(String message) {
        super(message);
    }

    public BeanException(String message, Throwable cause) {
        super(message, cause);
    }
}
