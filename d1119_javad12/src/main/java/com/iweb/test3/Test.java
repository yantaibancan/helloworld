package com.iweb.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/19 14:31
 */
public class Test {
    public static void main(String[] args) {
        Monster goblin = new Monster();
        goblin.setName("哥布林");
        goblin.setHp(10000);

        int n = 10000;
        List<Thread> addThreads = new ArrayList<>();
        List<Thread> reduceThreads = new ArrayList<>();
        //定义1w个负责调用recover方法给哥布林回血的进程
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    goblin.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads.add(t);
        }

        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    goblin.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads.add(t);
        }

        //我们最终是需要在主线程中访问哥布林的血量，所有必须保证主线程会等待上面2w个线程跑完后 再继续进行读取血量
        //所以要将2w个线程 join主线程
        for(Thread t:addThreads)
        {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(Thread t:reduceThreads)
        {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("哥布林最终血量为:"+goblin.getHp());
    }
}
