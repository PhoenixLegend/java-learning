package network;

import sun.net.util.IPAddressUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
//单线程
public class server {
    public static void main(String[] args)  {
        try {
            //服务端打开端口8888
            ServerSocket sserver = new ServerSocket(8888);

            //在8888端口上监听，看是否有连接请求过来
            System.out.println("监听在端口号:8888");
            Socket s =  sserver.accept();

            System.out.println("有连接过来" + s);
            //获取字节输入流对象，接收从客户端发过来的消息
           InputStream is = s.getInputStream();
//
//            System.out.println(is.read());
//            is.close();

            //把输入流封装在DataInputStream
            DataInputStream dis = new DataInputStream(is);

            while(true) {
//                System.out.println(dis.readUTF()); //接收结果是hello
//                //System.out.println(dis.read());
//                //关闭接受，关闭socket，关闭服务器
//                dis.close();
//                s.close();  //如下：需要持续输出便不再需要close

                //使用readUTF读取客户端的消息，并输出
                String msg=dis.readUTF();
                System.out.println("收到客户端消息："+msg);

                //获取字节输出流对象，向客户端发送消息
                OutputStream os=s.getOutputStream();

                //将对象封装在DataOutputStream里面
                DataOutputStream dos=new DataOutputStream(os);

                //从控制台录入要发送给客户端的数据
                Scanner sc=new Scanner(System.in);
                String str=sc.nextLine();

                //9、使用writeUTF向客户端发送数据
                dos.writeUTF(str);
            }
            //持续输出，不再关闭
            //sserver.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
