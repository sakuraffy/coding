package top.sakuraffy.bean.version2;

import top.sakuraffy.util.ClassUtils;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author: zhangqiushi
 * @create: 2021/07/16 16:36
 */
public class PackageResourceLoader {

    public Resource[] getResources(String basePackage) {
        String location = ClassUtils.convertClassNameToResourcePath(basePackage);
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource(location);
        File rootDir = new File(url.getFile());

        Set<File> matchingFile = retrieveMatchingFiles(rootDir);
        Resource[] result = new Resource[matchingFile.size()];
        int i = 0;
        for (File file : matchingFile) {
            result[i++] = new FileSystemResource(file);
        }
        return result;
    }

    private Set<File> retrieveMatchingFiles(File rootDir) {
        if (!rootDir.exists() || !rootDir.isDirectory() || !rootDir.canRead()) {
            return Collections.emptySet();
        }
        Set<File> result = new LinkedHashSet<>(8);
        doRetrieveMatchingFiles(rootDir, result);
        return result;
    }

    private void doRetrieveMatchingFiles(File dir, Set<File> result) {
        File[] dirContents = dir.listFiles();
        if (dirContents == null) {
            return;
        }

        for (File content : dirContents) {
            if (!content.isDirectory()) {
                result.add(content);
                continue;
            }
            if (content.canRead()) {
                doRetrieveMatchingFiles(content, result);
            }
        }
    }
}
