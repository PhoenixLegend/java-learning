package fileIO;

import org.junit.Test;

import java.io.*;
import java.util.Date;

public class test_fileIO {
    @Test
    public void  test_fileIO() throws IOException {
        // 本例子是找出c://windows中的所有文件，两种方法
        File file = new File("e://file.txt");
        long time = file.lastModified();
        Date da = new Date(time);
        System.out.println(da);
        File clist = new File("c://windows");
        System.out.println(clist.list().length);
        File[] cArry = clist.listFiles();
        System.out.println(cArry.length);
        for ( File name : cArry){
            System.out.println(name);
        }

        try {

            for (String path:clist.list()){
                System.out.println(path);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //注意，这里FileInputStream出现一定要加上异常处理，或者是这里加try catch，或者在class上throws异常
        FileInputStream fin = new FileInputStream(file);
        //获取数组长度
        byte[] all = new byte[(int)file.length()];
        //开始的时候需要打开read，完了之后需要close
        fin.read(all);
        for (byte word : all){
            //不然你就强制装换
            char n = (char) word;
            System.out.print(word);
            //直接打开就是数字byte类型
        }
        fin.close();
        //如果不关闭，会产生对资源占用的浪费。 当量比较大的时候，会影响到业务的正常开展。
        FileReader finChar = new FileReader(file);

        char[] allChar = new char[(int)file.length()];
        finChar.read(allChar);
        for (char word : allChar){
            System.out.print(word);
        }
        finChar.close();
        FileWriter fout = new FileWriter(file);
        char[] out = {'x','y'};
        fout.write(out);
        FileReader fread = new FileReader(file);
        BufferedReader breader = new BufferedReader(fread);
        while(true){
            String line = breader.readLine();
            System.out.println(line);
            if (line == null) break;
        }
    }
}
