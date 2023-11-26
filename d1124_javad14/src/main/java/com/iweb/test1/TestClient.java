package com.iweb.test1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author yiyu
 * @date 2023/11/24 15:38
 */
public class TestClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",8888);
        // System.out.println(s);
        // s.close();
        OutputStream os = s.getOutputStream();
        //封装数据流
        DataOutputStream dos = new DataOutputStream(os);
        //写入数据
        dos.writeUTF("zyn is 常州人");
    }
}
