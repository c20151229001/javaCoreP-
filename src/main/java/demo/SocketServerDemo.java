package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by LovlyCheng on 2016/8/20.
 */
public class SocketServerDemo {
    public  static void main(String ...args){
        try {
            ServerSocket serverSocket = new ServerSocket(8191);
            Socket incoming = serverSocket.accept();
            InputStream inputStream = incoming.getInputStream();
            OutputStream outputStream = incoming.getOutputStream();
            Scanner in = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream,true);
            printWriter.println("Hello！  Enter Bye To Exit.");
            while(in.hasNextLine()){
                String line = in.nextLine();
                printWriter.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
