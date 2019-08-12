package fileIO;

import org.junit.jupiter.api.Test;

import java.io.File;

public class text_fileDetection {
    @Test
    public void text_fileDetection(){
    File file = new File("e://file.txt");

    System.out.println("当前文件是：" +file);
    System.out.println("当前文件是：" +file.exists());
    System.out.println("当前文件是：" +file.isFile());
    System.out.println("当前文件是：" +file.isDirectory());
    System.out.println("当前文件是：" +file.toPath());
    System.out.println("当前文件是：" +file.toURI());
    System.out.println("当前文件是：" +file.toString());
}
}