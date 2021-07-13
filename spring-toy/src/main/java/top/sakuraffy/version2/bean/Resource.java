package top.sakuraffy.version2.bean;

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
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
