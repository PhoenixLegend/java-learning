package fileIO;

import charactor.Hero;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class test_HeroFile{
    @Test
    public static void main() throws Exception {
//File file = new File("e://file.txt");

//        System.out.println("当前文件是：" +file);
//        System.out.println("当前文件是：" +file.exists());
//        System.out.println("当前文件是：" +file.isFile());
//        System.out.println("当前文件是：" +file.isDirectory());
//        System.out.println("当前文件是：" +file.toPath());
//        System.out.println("当前文件是：" +file.toURI());
//        System.out.println("当前文件是：" +file.toString());


//        long time = file.lastModified();
//        Date da = new Date(time);
//        System.out.println(da);
//        File clist = new File("c://windows");
//        System.out.println(clist.list().length);
//        File[] cArry = clist.listFiles();
//        System.out.println(cArry.length);
//        for ( File name : cArry){
//            System.out.println(name);
//        }
//
//        try {
//
//            for (String path:clist.list()){
//                System.out.println(path);
//
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        //注意，这里FileInputStream出现一定要加上异常处理，或者是这里加try catch，或者在class上throws异常
//        FileInputStream fin = new FileInputStream(file);
//        //获取数组长度
//        byte[] all = new byte[(int)file.length()];
//        //开始的时候需要打开read，完了之后需要close
//        fin.read(all);
//        for (byte word : all){
//            //不然你就强制装换
//            char n = (char) word;
//            System.out.print(word);
//            //直接打开就是数字byte类型
//        }
//        fin.close();
//        //如果不关闭，会产生对资源占用的浪费。 当量比较大的时候，会影响到业务的正常开展。
//        FileReader finChar = new FileReader(file);
//
//        char[] allChar = new char[(int)file.length()];
//        finChar.read(allChar);
//        for (char word : allChar){
//            System.out.print(word);
//        }
//        finChar.close();
//        FileWriter fout = new FileWriter(file);
//        char[] out = {'x','y'};
//        fout.write(out);
//        FileReader fread = new FileReader(file);
//        BufferedReader breader = new BufferedReader(fread);
//        while(true){
//            String line = breader.readLine();
//            System.out.println(line);
//            if (line == null) break;
//        }
//
//        Hero h = new Hero();
//        h.name = "garen";
//        h.hp = 616;
//
//        //准备一个文件用于保存该对象
//        File f =new File("E:/garen.lol");
//
//        try(
//                //创建对象输出流
//                FileOutputStream fos = new FileOutputStream(f);
//                ObjectOutputStream oos =new ObjectOutputStream(fos);
//                //创建对象输入流
//                FileInputStream fis = new FileInputStream(f);
//                ObjectInputStream ois = new ObjectInputStream(fis);
//        ) {
//            oos.writeObject(h);
//            Hero h2 = (Hero) ois.readObject();
//            System.out.println(h2.name);
//            System.out.println(h2.hp);
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        try (InputStream is = System.in) {
//            while (true) {
//                // 敲入a,然后敲回车可以看到
//                // 97 13 10
//                // 97是a的ASCII码
//                // 13 10分别对应回车换行
//                int i = is.read();
//                System.out.println(i);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ArrayList<Hero> a = new ArrayList<>();
//        a.add(new Hero());
//        a.add(new Hero());
//        System.out.println(a.size());
//        System.out.println(a.toString());
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        System.out.println(map.get(1));
    }
}



