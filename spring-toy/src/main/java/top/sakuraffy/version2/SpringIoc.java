package top.sakuraffy.version2;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: coding
 * @description: 实现简单的springIOC功能
 * @author: zhangqiushi
 * @create: 2021/07/11 15:22
 */
public class SpringIoc {

    public static final String BEAN_ID_ATTRIBUTE = "id";
    public static final String BEAN_CLASS_ATTRIBUTE = "class";
    public static final String BEAN_PROPERTY_ATTRIBUTE = "property";
    public static final String PROPERTY_NAME_ATTRIBUTE = "name";
    public static final String PROPERTY_VALUE_ATTRIBUTE = "value";
    public static final String PROPERTY_REF_ATTRIBUTE = "ref";

    public static Map<String, Object> singletonBeans = new HashMap<>();
    public static Map<String, Object> singletonObjects = new HashMap<>();

    public void loadBeanDefinitionResource(String path) throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
        SAXReader reader = new SAXReader();
        Document document = reader.read(is);
        Element root = document.getRootElement();
        Iterator<Element> iterator = root.elementIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            parseBeanElement(element);
        }
    }

    /**
     * 解析Bean元素
     * @param element
     */
    private void parseBeanElement(Element element) throws Exception {
        String beanId = element.attributeValue(BEAN_ID_ATTRIBUTE);
        String beanClassName = element.attributeValue(BEAN_CLASS_ATTRIBUTE);
        Object obj = Class.forName(beanClassName).newInstance();
        parsePropertyElementValue(element, obj);
        singletonBeans.put(beanId, obj);
    }

    /**
     * 解析属性元素
     * @param element
     * @param obj
     */
    private void parsePropertyElementValue(Element element, Object obj) throws Exception {
        Iterator<Element> iterator = element.elementIterator(BEAN_PROPERTY_ATTRIBUTE);
        while (iterator.hasNext()) {
            Element propertyElement = iterator.next();
            String propertyName = propertyElement.attributeValue(PROPERTY_NAME_ATTRIBUTE);
            if (StringUtils.isEmpty(propertyName)) {
                return;
            }

            boolean hasRefAttribute = propertyElement.attribute(PROPERTY_REF_ATTRIBUTE) != null;
            boolean hasValueAttribute = propertyElement.attribute(PROPERTY_VALUE_ATTRIBUTE) != null;

            if (hasRefAttribute) {
                String refName = propertyElement.attributeValue(PROPERTY_REF_ATTRIBUTE);
                Object object = singletonBeans.get(refName);
                if (object == null) {

                } else {
                    BeanUtils.copyProperty(obj, propertyName, object);
                }
            } else if (hasValueAttribute) {
                String value = propertyElement.attributeValue(PROPERTY_VALUE_ATTRIBUTE);
                BeanUtils.copyProperty(obj, propertyName, value);
            } else {
                throw new RuntimeException(propertyName + " must specify a ref or value");
            }
        }
    }

    public Object getBean(String beanId) {
        return singletonBeans.get(beanId);
    }
}
