package top.sakuraffy.bean;

import org.apache.commons.lang.StringUtils;
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

    public static final String BEAN_NAMESPACE_URI = "http://www.springframework.org/schema/beans";
    public static final String CONTEXT_NAMESPACE_URI = "http://www.springframework.org/schema/context";
    public static final String AOP_NAMESPACE_URI = "http://www.springframework.org/schema/aop";

    public static final String BEAN_ID_ATTRIBUTE = "id";
    public static final String BEAN_CLASS_ATTRIBUTE = "class";
    public static final String BEAN_PROPERTY_ATTRIBUTE = "property";
    public static final String PROPERTY_NAME_ATTRIBUTE = "name";
    public static final String PROPERTY_VALUE_ATTRIBUTE = "value";
    public static final String PROPERTY_REF_ATTRIBUTE = "ref";

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
                switch (element.getNamespaceURI()) {
                    case BEAN_NAMESPACE_URI: parseBeanElement(element); break;
                    case CONTEXT_NAMESPACE_URI: parseContextElement(element); break;
                    default:
                }
            }
        } catch (DocumentException | IOException e) {
            throw new BeanDefinitionException("IOException parsing XML document:" + configurationFile, e);
        }
    }

    /**
     * 解析Bean元素
     * @param element
     */
    private void parseBeanElement(Element element) {
        String beanId = element.attributeValue(BEAN_ID_ATTRIBUTE);
        String beanClassName = element.attributeValue(BEAN_CLASS_ATTRIBUTE);
        BeanDefinition bd = new GenericBeanDefinition(beanId, beanClassName);
        parsePropertyElementValue(element, bd);
        this.registry.registerBeanDefinition(beanId, bd);
    }

    /**
     * 解析Context元素
     * @param element
     */
    private void parseContextElement(Element element) {

    }

    /**
     * 解析属性元素
     * @param element
     * @param bd
     */
    private void parsePropertyElementValue(Element element, BeanDefinition bd) {
        Iterator<Element> iterator = element.elementIterator(BEAN_PROPERTY_ATTRIBUTE);
        while (iterator.hasNext()) {
            Element propertyElement = iterator.next();
            String propertyName = propertyElement.attributeValue(PROPERTY_NAME_ATTRIBUTE);
            if (StringUtils.isEmpty(propertyName)) {
                return;
            }

            Object value = parsePropertyElementValue(propertyElement, propertyName);
            PropertyValue propertyValue = new PropertyValue(propertyName, value);
            bd.getPropertyValues().add(propertyValue);
        }
    }

    private Object parsePropertyElementValue(Element propertyElement, String propertyName) {
        String elementName = (propertyName != null) ?
                "<property> element for property '" + propertyName + "' " : "<constructor-arg> element";

        boolean hasRefAttribute = propertyElement.attribute(PROPERTY_REF_ATTRIBUTE) != null;
        boolean hasValueAttribute = propertyElement.attribute(PROPERTY_VALUE_ATTRIBUTE) != null;

        if (hasRefAttribute) {
            String refName = propertyElement.attributeValue(PROPERTY_REF_ATTRIBUTE);
            RuntimeBeanReference ref = new RuntimeBeanReference(refName);
            return ref;
        } else if (hasValueAttribute) {
            String value = propertyElement.attributeValue(PROPERTY_VALUE_ATTRIBUTE);
            TypedStringValue valueHolder = new TypedStringValue(value);
            return valueHolder;
        } else {
            throw new RuntimeException(elementName + " must specify a ref or value");
        }
    }
}
