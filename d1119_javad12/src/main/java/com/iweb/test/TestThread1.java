package com.iweb.test;

/**线程的休眠 sleep
 * sleep会使当前线程暂停运行，并且放弃jvm的调度资源
 * 其他线程可以在该线程sleep期间内获取jvm调度
 * 线程有指定sleep时间 时间到了之后 线程会恢复
 * @author yiyu
 * @date 2023/11/19 9:42
 */
public class TestThread1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                double times = 0;
                while(true)
                {
                    System.out.println("我要休眠10ms了");
                    try {
                        Thread.sleep(10);
                        System.out.println("我恢复了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    times+=0.01;
                    System.out.println("线程已经运行的时间为:"+times);
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true)
                {
                    System.out.println("t2抢到了调度资源");
                }
            }
        };

        t1.start();
        t2.start();
    }
}
