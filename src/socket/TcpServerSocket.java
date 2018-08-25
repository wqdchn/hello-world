package socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @program: hello-world
 * @description: 服务端
 * @author: wqdong
 * @create: 2018-08-24 19:41
 **/
public class TcpServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        while (true){
            Socket s = new Socket();
            s = ss.accept();
            System.out.println("Client Info");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = dis.readUTF();
            System.out.println(str);
        }
    }
}
