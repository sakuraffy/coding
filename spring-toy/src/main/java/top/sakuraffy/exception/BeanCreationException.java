package top.sakuraffy.exception;

/**
 * @author
 * @author Sakuraffy
 * @date 2021/7/8 22:48
 */
public class BeanCreationException extends BeanException {

    public BeanCreationException(String message) {
        super(message);
    }

    public BeanCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
