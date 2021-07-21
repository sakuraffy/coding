package top.sakuraffy.bean.version2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: zhangqiushi
 * @create: 2021/07/16 16:38
 */
public class FileSystemResource implements Resource {

    private File file;

    public FileSystemResource(File file) {
        this.file = file;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }
}
