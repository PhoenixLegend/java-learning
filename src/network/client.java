package network;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
    public static void main(String[] args)  {

        try {
            //连接到本机的8888端口
            Socket s = new Socket("127.0.0.1",8888);
            System.out.println(s);
            //获取字节输出流对象，用于像服务器端发送消息
            OutputStream os = s.getOutputStream();
//            os.write(2);
            //将输出流封装在DataOutputStream里面
            DataOutputStream dos = new DataOutputStream(os);
            //dos.writeBytes("hello"); //接受结果是104

            while(true) {
                Scanner input = new Scanner(System.in);
                String sc = input.next();
                dos.writeUTF(sc);
                //获取字节输入流对象，用于读取从服务器端接收的数据
                InputStream is=s.getInputStream();

                //将输入流封装在DataInputStream里面
                DataInputStream dis=new DataInputStream(is);

                //使用readUTF读取服务器接收到的数据并输出
                String response=dis.readUTF();
                System.out.println("收到服务器端消息："+response);

//                //停止写入，关闭写入流，关闭socket
//                dos.close();
//                os.close();
//                s.close();
            }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
