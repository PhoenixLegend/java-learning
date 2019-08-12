package reflection;

import charactor.Hero;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflection {
    @Test
    public void TestReflection() throws ClassNotFoundException {
//        Class class1 = Class.forName("charactor.Hero");
//        Class class2=Hero.class;
//        Class class3=new Hero().getClass();
        //三种获取类对象的方式
//        System.out.println(class1==class2);
//        System.out.println(class2==class3);

        // 获取类对象，都会导致静态属性被初始化，而且只会执行一次。
        // 除了直接使用 Class c = Hero.class 这种方式，这种方式不会导致静态属性被初始化

        //传统的使用new的方式创建对象
//        Hero h1 =new Hero();
//        h1.name = "teemo";
//        System.out.println(h1);

        try {
            Class p = Hero.class;
            Constructor pc = p.getConstructor();
            Hero Teemo = (Hero) pc.newInstance();

//
//            //Teemo.name = "Teemo";
//            System.out.println(Teemo.toString());
//            //获取类Hero的名字叫做name的字段
//            //这里使用反射机制修改类的属性
//            Field f1 = Teemo.getClass().getDeclaredField("name");
//            f1.set(Teemo,"Teeno");
//
//            System.out.println(Teemo.toString());
            // 调用方法
            // 获取这个名字叫做setName，参数类型是String的方法
            Method m = p.getClass().getMethod("setName",String.class);
            // 对h对象，调用这个方法
            m.invoke(p, "Garen");

            // 使用传统的方式，调用getName方法
            System.out.println(p.getName());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
