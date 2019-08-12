package fileIO;

import charactor.Hero;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class test_HeroFile{
    @Test
    public static void main() throws Exception {
    Hero h = new Hero();
    h.name = "garen";
    h.hp = 616;
    //准备一个文件用于保存该对象
    File f =new File("E:/garen.lol");

    try(
            //创建对象输出流
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            //创建对象输入流
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
    ) {
        oos.writeObject(h);
        Hero h2 = (Hero) ois.readObject();
        System.out.println(h2.name);
        System.out.println(h2.hp);

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try (InputStream is = System.in) {
        while (true) {
            // 敲入a,然后敲回车可以看到
            // 97 13 10
            // 97是a的ASCII码
            // 13 10分别对应回车换行
            int i = is.read();
            System.out.println(i);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    ArrayList<Hero> a = new ArrayList<>();
    a.add(new Hero());
    a.add(new Hero());
    System.out.println(a.size());
    System.out.println(a.toString());
//        HashMap<Integer,String> map = new HashMap<>();
//        map.put(1,"hello");
//        System.out.println(map.get(1));
    }
}



