package socket;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: hello-world
 * @description: 客户端
 * @author: wqdong
 * @create: 2018-08-24 19:49
 **/
public class TcpClientSocket {
    public static void main(String args[]) throws Exception{
        Socket s = new Socket("127.0.0.1",1234);
        /*Client申请连接到Server端上*/
        /*连接上服务器端以后，就可以向服务器端输出信息和接收从服务器端返回的信息
        输出信息和接收返回信息都要使用流式的输入输出原理进行信息的处理*/
        /*这里是使用输出流OutputStream向服务器端输出信息*/
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        System.out.println("Send Msg");
        Thread.sleep(30000);/*客户端睡眠3秒后再向服务器端发送信息*/
        dos.writeUTF("Hello Server!");
    }
}
