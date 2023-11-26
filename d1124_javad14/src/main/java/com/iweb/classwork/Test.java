package com.iweb.classwork;

import com.iweb.classwork.DAO.ReplyDao;
import com.iweb.classwork.DAO.impl.ReplyDaoImpl;

/**
 * @author yiyu
 * @date 2023/11/24 16:43
 */
public class Test {
    public static void main(String[] args) {
        ReplyDao replyDao = new ReplyDaoImpl();
        System.out.println(replyDao.listByReceiveLike("1256"));
    }
}
