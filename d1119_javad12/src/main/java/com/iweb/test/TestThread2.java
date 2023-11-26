package com.iweb.test;

/**join main方法对应的主线程 在一开始的时候一定是最先运行
 * 只有主线程运行了 其他对象才会被实例化
 * 从而才能进入到就绪态
 * @author yiyu
 * @date 2023/11/19 9:53
 */
public class TestThread2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是t1");
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是t2");
                }
            }
        };

        t1.start();
        t2.start();
        try {
            //代码运行到这一行的时候 一直是主线程在运行
            //当t1 join了主线程之后 只有当t1线程的run方法运行完成之后
            //主线程才会继续运行
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t3 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是t3");
                }
            }
        };

        t3.start();
    }
}
