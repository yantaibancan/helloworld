package com.iweb.test1;

/**消费者负责吃馒头 所有消费者线程绑定的篮子必须是同一个
 * @author yiyu
 * @date 2023/11/22 19:00
 */
public class Consumer implements Runnable{
    Basket bt;
    public Consumer(Basket bt)
    {
        this.bt=bt;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            ManTou mt = bt.pop();
            System.out.println("消费者消费了"+mt);
        }
    }
}
