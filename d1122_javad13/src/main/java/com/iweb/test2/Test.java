package com.iweb.test2;

/**
 * @author yiyu
 * @date 2023/11/22 20:39
 */
public class Test {
    public static void main(String[] args) {
        //实例化一个线程池对象
        ThreadPool pool = new ThreadPool();
        /*
        //定义若干个任务线程 用来代表需要被执行的任务
        for (int i = 0; i < 50; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("我是任务需要执行的操作");
                }
            };
            //将生产的任务添加到线程池的任务容器中
            pool.add(task);
        }
        //延长主线程运行时间 观察运行结束
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("运行结束");
        */

        //创建一个场景 假设任务运行需要一秒的时间
        //开始的时候是间隔一秒钟向线程池添加任务
        //然后不断减少投放任务的时间间隔
        //执行任务的线程还没有来得及结束
        //新的任务就又来了
        int sleep = 1000;
        while (true)
        {
            pool.add(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(sleep);
                sleep = sleep>100?sleep-100:100;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
