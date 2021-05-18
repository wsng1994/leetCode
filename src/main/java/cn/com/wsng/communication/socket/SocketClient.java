package cn.com.wsng.communication.socket;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author wsng
 * @date 2019/12/3
 */
public class SocketClient {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1",9080);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write("00000014abcdefghijklmn");
            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String output = br.readLine();
            System.out.println("服务器："+ output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String client(){
        String out = "";

        return out;
    }
}
