package com.iweb.homework;

/**
 * @author yiyu
 * @date 2023/11/24 23:16
 */
public class Q29 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (o1)
                {
                    System.out.println("t1 o1 win");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (o2)
                    {
                        System.out.println("t1 o2 win");
                        try {
                            Thread.sleep(1000);
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
                synchronized (o2)
                {
                    System.out.println("t2 o2 win");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (o1)
                    {
                        System.out.println("t2 o1 win");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
