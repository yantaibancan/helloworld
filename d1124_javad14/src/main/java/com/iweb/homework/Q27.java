package com.iweb.homework;

/**
 * @author yiyu
 * @date 2023/11/24 23:04
 */
public class Q27 {
    static int a = 0;
    public static void main(String[] args) {
        Object o = new Object();
        for (int i = 0; i < 5000; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    synchronized (o)
                    {
                        a++;
                    }
                }
            };
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 5000; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    synchronized (o)
                    {
                        a--;
                    }
                }
            };
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(a);

    }
}
