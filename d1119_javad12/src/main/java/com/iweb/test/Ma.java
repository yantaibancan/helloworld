package com.iweb.test;

import java.util.Random;

/**
 * @author yiyu
 * @date 2023/11/19 11:02
 */
public class Ma {
    static int num = -1;
    static String[] skill = {"接","化","发","闪电五连鞭"};
    static int[] arr ={1000,1000,1000,2000};
    public static void main(String[] args) {


        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true)
                {
                    System.out.println("接");
                    num = 1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("化");
                    num = 2;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("发");
                    num = 3;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("闪电五连鞭");
                    num = 4;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };


        Thread t2 = new Thread(){
            @Override
            public void run() {
                Random r = new Random();
                int num2;
                while(true)
                {
                    try {
                        sleep(arr[num-1]);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    num2=r.nextInt(101);
                    if(50<num2 & num2<61)
                    {
                        System.out.println("打断技能"+"  "+skill[num-1]);
                        t1.stop();
                    }

                }
            }
        };
        t1.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.setDaemon(true);
        t2.start();

    }
}
