package com.iweb.test5;

/**线程交互 wait notify notifyAll 同步对象方法(Object)
 * 这三个代码必须出现在同步代码块中
 * wait方法 让占有当前同步对象锁的进程 进入到等待状态 释放临时锁
 * 直到同步对象调用了notify或者notifyAll方法
 * 线程在重新获得锁的前提下 从wait的地方继续运行
 * 默认状态下 处于wait状态的线程 如果同步对象没有调用notify方法 就会一直处于wait状态
 *
 * notify方法  每一个同步对象都会有一个等待列表  记录的是被其所wait的线程是哪些
 * notify方法的作用  是从当前同步对象的等待列表中选择一个线程进行唤醒
 *
 * notifyAll 唤醒同步对象等待列表中所有处于wait状态的线程
 *
 * @author yiyu
 * @date 2023/11/19 15:35
 */
public class Test {
    public static void main(String[] args) {
        Monster goblin = new Monster();
        goblin.setName("哥布林");
        goblin.setHp(500);
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true)
                {
                    goblin.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true)
                {
                    goblin.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
