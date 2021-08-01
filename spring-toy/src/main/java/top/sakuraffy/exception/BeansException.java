package top.sakuraffy.exception;

/**
 * @author Sakuraffy
 * @date 2021/7/13 22:32
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
