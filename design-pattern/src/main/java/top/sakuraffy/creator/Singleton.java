package top.sakuraffy.creator;

import java.io.ObjectStreamException;

/**
 * @author: zhangqiushi
 * @create: 2021/08/26 11:53
 */
public class Singleton {
    /**
     *  懒汉式, 线程安全
     */
    public static class LazySingleton {
        private static final LazySingleton instance = new LazySingleton();

        private LazySingleton() { }

        public static LazySingleton newInstance() {
            return instance;
        }
    }

    /**
     *  懒汉式, 线程不安全
     */
    public static class HungrySingleton {
        private static HungrySingleton instance;

        private HungrySingleton() {}

        public static HungrySingleton newInstance() {
            if (instance == null) {
                instance = new HungrySingleton();
            }
            return instance;
        }
    }

    /**
     *  DoubleCheck JVM优化重排可能存在问题（加上volatile可避免）
     */
    public static class DoubleCheckSingleton {
        private static volatile DoubleCheckSingleton instance = null;

        private DoubleCheckSingleton() {
            if (instance != null) {
                throw  new RuntimeException();
            }
        }

        public static DoubleCheckSingleton newInstance() {
            if (instance == null){
                synchronized (DoubleCheckSingleton.class) {
                    // 避免判断了instance==null的等待线程重复创建instance
                    if (instance == null){
                        instance = new DoubleCheckSingleton();
                    }
                }
            }
            return instance;
        }

        private Object readResolve() throws ObjectStreamException {
            return instance;
        }
    }

    /**
     *  内部类实现，可解决优化重排问题
     */
    public static class InnerClassSingleton {
        private static class SingletonInstance {
            private static final InnerClassSingleton instance = new InnerClassSingleton();
        }

        public static InnerClassSingleton newInstance() {
            return SingletonInstance.instance;
        }
    }

    /**
     *  枚举实现，天然单例
     */
    public static enum EnumSingleton {
        instance
    }

    public static void main(String[] args) {
        LazySingleton s11 = LazySingleton.newInstance();
        LazySingleton s12 = LazySingleton.newInstance();
        System.out.println(s11 == s12);


        HungrySingleton s21 = HungrySingleton.newInstance();
        HungrySingleton s22 = HungrySingleton.newInstance();
        System.out.println(s21 == s22);

        DoubleCheckSingleton s31 = DoubleCheckSingleton.newInstance();
        DoubleCheckSingleton s32 = DoubleCheckSingleton.newInstance();
        System.out.println(s31 == s32);

        InnerClassSingleton s41 = InnerClassSingleton.newInstance();
        InnerClassSingleton s42 = InnerClassSingleton.newInstance();
        System.out.println(s41 == s42);

        EnumSingleton s51 = EnumSingleton.instance;
        EnumSingleton s52 = EnumSingleton.instance;
        System.out.println(s51 == s52);
    }
}
