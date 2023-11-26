package com.iweb.classwork;

import com.iweb.classwork.DAO.ReplyDao;
import com.iweb.classwork.DAO.impl.ReplyDaoImpl;
import com.iweb.classwork.entity.Reply;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author yiyu
 * @date 2023/11/24 16:07
 */
public class TaoBaoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("正在监听8888端口");
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos = new DataOutputStream(os);
        ReplyDao replyDao = new ReplyDaoImpl();
        Random r = new Random();
        while (true)
        {
            String str = dis.readUTF();
            System.out.println("收到客户端消息:"+str);
            List<Reply> replyList = replyDao.listByReceiveLike(str);
            dos.writeUTF(replyList.get(r.nextInt(replyList.size())).getResponse());
        }
    }
}
