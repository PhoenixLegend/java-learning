package network;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestSocket {
    public static void main(String[] args) throws UnknownHostException {
//        Inet4Address ip4 = (Inet4Address) Inet4Address.getLocalHost();
//        //上下基本上一样，只不过用Inet4Address的话需要cast之后才能用
//        InetAddress ip = InetAddress.getLocalHost();
//        String ipString = ip.getHostAddress();
//        System.out.println(ipString);
        try {
            //process: Returns the output stream
            Process p = Runtime.getRuntime().exec("ping " + "192.168.2.106");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"gbk"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while(null != (line = br.readLine())){
                if(line.length()!=0){
                    sb.append(line+"\n\r");
                }
            }
            System.out.println(sb.toString());

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
