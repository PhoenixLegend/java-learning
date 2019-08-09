package reflection;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class testSpring {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws Exception {

        //从spring.txt中获取类名称和方法名称
        File springConfigFile = new File("E:\\java-learning\\src\\reflection\\spring.txt");
        //file就是个路径，properties才是获取文件参数的对象
        Properties springConfigProperties= new Properties();
        springConfigProperties.load(new FileInputStream(springConfigFile));
        String className = (String) springConfigProperties.get("class");
        String methodName = (String) springConfigProperties.get("method");

        //根据类名称获取类对象
        Class clazz = Class.forName(className);
        //根据方法名称，获取方法对象
        Method m = clazz.getMethod(methodName);
        //获取构造器
        Constructor c = clazz.getConstructor();
        //根据构造器，实例化出对象
        Object service = c.newInstance();
        //调用对象的指定方法
        m.invoke(service);
        //这样写的好处，在于需要修改服务的时候，只需要在配置文件里面更改service就可以了
    }
}
