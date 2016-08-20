package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by LovlyCheng on 2016/8/17.
 */
public class socketProgrammingDemo {
    private static final  String HOST ="127.0.0.1";
    private static final  String NAME ="www.baidu.com";
    private static final  int PORT =8191;


    public static  void main(String ...args){

        Socket s = new Socket();
        try {
            s.connect(new InetSocketAddress(HOST,PORT),10000);
            if(s.isConnected()){
                s.setKeepAlive(true);
            }
            OutputStream out = s.getOutputStream();
            InputStream input = s.getInputStream();
            out.write("你妹".getBytes());
            out.flush();
            Scanner in = new Scanner(System.in);
            while (true){
                if(in.hasNextLine()){
                    String line = in.nextLine();
                    out.write(line.getBytes());
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            InetAddress[] address = InetAddress.getAllByName(NAME);
//            for (InetAddress a: address) {
//                System.err.println(a);
//            }
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }


    }

}
