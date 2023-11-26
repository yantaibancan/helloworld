package com.iweb.homework;

/**
 * @author yiyu
 * @date 2023/11/24 23:12
 */
public class Q28 {
    public static void main(String[] args) {
        Object o = new Object();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true)
                {
                    synchronized (o)
                    {
                        o.notify();
                        System.out.print("A");
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true)
                {
                    synchronized (o)
                    {
                        o.notify();
                        System.out.print("B");
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
