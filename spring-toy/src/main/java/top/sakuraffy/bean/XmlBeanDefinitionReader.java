package top.sakuraffy.bean;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import top.sakuraffy.exception.BeanDefinitionException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import static com.sun.org.apache.xml.internal.security.utils.Constants.configurationFile;

/**
 * @author Sakuraffy
 * @date 2021/7/7 21:47
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    public static final String BEAN_ID_ATTRIBUTE = "id";
    public static final String BEAN_CLASS_ATTRIBUTE = "class";

    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    /**
     * 加载bean定义资源
     * @param resource
     * @throws BeanDefinitionException
     */
    @Override
    public void loadBeanDefinitionResource(Resource resource) {
        try {
            InputStream is = resource.getInputStream();
            SAXReader reader = new SAXReader();
            Document document = reader.read(is);
            Element root = document.getRootElement();
            Iterator<Element> iterator = root.elementIterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                String beanId = element.attributeValue(BEAN_ID_ATTRIBUTE);
                String beanClassName = element.attributeValue(BEAN_CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(beanId, beanClassName);
                this.registry.registerBeanDefinition(beanId, bd);
            }
        } catch (DocumentException | IOException e) {
            throw new BeanDefinitionException("IOException parsing XML document:" + configurationFile, e);
        }
    }
}
