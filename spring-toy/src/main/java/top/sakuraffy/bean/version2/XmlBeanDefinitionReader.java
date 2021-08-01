package top.sakuraffy.bean.version2;

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
    public static final String BEAN_CONSTRUCTOR_ATTRIBUTE = "constructor-arg";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String TYPE_ATTRIBUTE = "type";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String REF_ATTRIBUTE = "ref";
    public static final String BASE_PACKAGE_ATTRIBUTE = "base-package";

    private BeanDefinitionRegistry registry;
    private PackageResourceLoader packageResourceLoader = new PackageResourceLoader();

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
        parseConstructorElementValue(element, bd);
        parsePropertyElementValue(element, bd);
        this.registry.registerBeanDefinition(beanId, bd);
    }


    /**
     * 解析Context元素
     * @param element
     */
    private void parseContextElement(Element element) {
        String basePackages = element.attributeValue(BASE_PACKAGE_ATTRIBUTE);
        Resource[] resources = packageResourceLoader.getResources(basePackages);
        System.out.println(resources.length);
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
            String propertyName = propertyElement.attributeValue(NAME_ATTRIBUTE);
            if (StringUtils.isEmpty(propertyName)) {
                return;
            }

            Object value = parsePropertyElementValue(propertyElement, propertyName);
            PropertyValue propertyValue = new PropertyValue(propertyName, value);
            bd.getPropertyValues().add(propertyValue);
        }
    }

    /**
     * 解析Bean构造函数
     * @param element
     * @param bd
     */
    private void parseConstructorElementValue(Element element, BeanDefinition bd) {
//        String typeAttr = element.attributeValue(TYPE_ATTRIBUTE);
//        String nameAttr = element.attributeValue(NAME_ATTRIBUTE);
//        Object value = parsePropertyElementValue(element, null);
//        ConstructorArgument.ValueHolder valueHolder = new ConstructorArgument.ValueHolder(value);
//        if (StringUtils.isNotEmpty(typeAttr)) {
//            valueHolder.setType(typeAttr);
//        }
//        if (StringUtils.isNotEmpty(nameAttr)) {
//            valueHolder.setName(nameAttr);
//        }
//        bd.getConstructorArgument().addArgumentValue(valueHolder);
    }


    private Object parsePropertyElementValue(Element propertyElement, String propertyName) {
        String elementName = (propertyName != null) ?
                "<property> element for property '" + propertyName + "' " : "<constructor-arg> element";

        boolean hasRefAttribute = propertyElement.attribute(REF_ATTRIBUTE) != null;
        boolean hasValueAttribute = propertyElement.attribute(VALUE_ATTRIBUTE) != null;

        if (hasRefAttribute) {
            String refName = propertyElement.attributeValue(REF_ATTRIBUTE);
            RuntimeBeanReference ref = new RuntimeBeanReference(refName);
            return ref;
        } else if (hasValueAttribute) {
            String value = propertyElement.attributeValue(VALUE_ATTRIBUTE);
            TypedStringValue valueHolder = new TypedStringValue(value);
            return valueHolder;
        } else {
            throw new RuntimeException(elementName + " must specify a ref or value");
        }
    }
}
