package cn.com.wsng.communication.socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author wsng
 * @date 2019/12/3
 */
public class SocketServer {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(9080);
            System.out.println("启动服务器....");
            Socket socket = serverSocket.accept();
            System.out.println("客户端:"+socket.getInetAddress().getHostAddress()+"已连接到服务器");
            String acceptMsg = readStream(socket.getInputStream());
            System.out.println("客户端："+acceptMsg);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(acceptMsg+"\n");
            bw.flush();
        }catch (IOException ie){
            ie.fillInStackTrace();
        }
    }



    public static String readStream(InputStream is) {
        /**
         *
         */
        byte[] a = new byte[0];
        try {
            byte[] messageLen = new byte[8];
            is.read(messageLen, 0, 8);
            int len = 0;
            len = Integer.valueOf(new String(messageLen));
            byte[] message = new byte[len];
            is.read(message, 0, len);
            a= message;
            return new String(message,"utf-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

       return "";
    }
}
