package com.iweb.test;

import com.iweb.test2.Ticket;

/**
 * @author yiyu
 * @date 2023/11/19 11:20
 */
public class User extends Thread{
    public User(String name, Ticket ticket)
    {
        super(name);
    }
    @Override
    public void run() {
        System.out.println("用户"+this.getName()+"抢到了票:");
    }
}
