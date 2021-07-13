package top.sakuraffy.version1.bean;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: zhangqiushi
 * @create: 2021/07/13 13:02
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    protected final Map<String, Object> singletonObjects = new ConcurrentHashMap(256);
    protected final Map<String, ObjectFactory<?>> singletonFactories = new HashMap(16);
    protected final Map<String, Object> earlySingletonObjects = new HashMap(16);
    protected final Set<String> registeredSingletons = new HashSet<>(256);

    private final Set<String> singletonsCurrentlyInCreation = new HashSet<>(16);

    @Override
    public void registerSingleton(String name, Object object) {

    }

    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = this.singletonObjects.get(beanName);
        if (singletonObject == null) {
            singletonObject = this.earlySingletonObjects.get(beanName);
        }

        return singletonObject;
    }

    @Override
    public boolean containsSingleton(String name) {
        return false;
    }

    public boolean isSingletonsCurrentlyInCreation(String name) {
        return singletonsCurrentlyInCreation.contains(name);
    }

    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        synchronized(this.singletonObjects) {
            if (!this.singletonObjects.containsKey(beanName)) {
                this.singletonFactories.put(beanName, singletonFactory);
                this.earlySingletonObjects.remove(beanName);
                this.registeredSingletons.add(beanName);
            }

        }
    }
}
