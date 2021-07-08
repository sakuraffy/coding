package top.sakuraffy.bean;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Sakuraffy
 * @date 2021/7/7 21:42
 */
public interface Resource {

    /**
     * 获取输入流
     * @return
     */
    InputStream getInputStream() throws IOException;
}
