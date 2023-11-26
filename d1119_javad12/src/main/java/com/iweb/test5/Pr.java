package com.iweb.test5;

/**
 * @author yiyu
 * @date 2023/11/19 15:57
 */
public class Pr {
    public synchronized void printA()
    {
        System.out.println("A");
        this.notify();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void printB()
    {
        System.out.println("B");
        this.notify();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Pr pr = new Pr();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true)
                {
                    pr.printA();
                    try {
                        Thread.sleep(1000);
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
                    pr.printB();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
