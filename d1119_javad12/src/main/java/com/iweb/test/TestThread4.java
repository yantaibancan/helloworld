package com.iweb.test;

/**守护线程  守护线程会在所有其他所有非守护线程都运行结束之后停止运行
 * GC 本质也是守护线程
 * @author yiyu
 * @date 2023/11/19 10:35
 */
public class TestThread4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                int time = 0;
                while (true)
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("已经过去了"+ ++time+"秒");
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是线程t2，当前运行次数为"+(i+1));
                }
            }
        };
        t1.setDaemon(true);
        t1.start();
        t2.start();
        System.out.println("主线程开始sleep");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程运行结束");
    }
}
