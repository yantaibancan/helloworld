package com.iweb.test2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/19 13:41
 */
public class TicketShop {
    private LinkedList<Ticket> ticketList;
    public TicketShop()
    {
        ticketList=new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ticketList.add(new Ticket(i+1));
        }
    }

    //synchronized 加锁
    //被多线程进行资源竞争的对象 叫做同步对象
    //每一个同步对象 都拥有一个同步对象锁 锁具有唯一性
    //当线程进入到synchronized锁修饰的方法或者代码块中的时候
    //当前线程会获取同步对象的锁 在方法运行完成之前，锁不会被释放
    //如果在这个时候 其他线程被cpu切换，想调用这个方法 会因为没有锁无法调用
    //这个现象叫做线程的阻塞
    //其他线程必须要等到获取锁的线程将锁释放了 才能进入到方法中 获取锁
    //synchronized保证的是 在单位时间内 能够执行相关的代码的线程 只有一个
    public Ticket getTicket()
    {
        synchronized (this)
        {
            if(ticketList.isEmpty())
            {
                return null;
            }
            return ticketList.removeLast();
        }
    }
}
