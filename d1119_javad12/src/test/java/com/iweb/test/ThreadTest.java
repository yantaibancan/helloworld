package com.iweb.test;

import org.junit.Test;

/**
 * @author yiyu
 * @date 2023/11/19 9:06
 */
public class ThreadTest {
@Test
    public void threadTest1()
    {
        //实例化线程对象
        FightRice fr1 = new FightRice("lyh");
        FightRice fr2 = new FightRice("ztb");
        FightRice fr3 = new FightRice("丁真");
        //线程的职责是运行完成自己的run方法
        //线程需要通过调用start方法使线程自己进入到就绪态
        //进入到就绪态的进程，才有机会被jvm进行调度
        //单位时间内 只会有一个线程被jvm进行调度
        //jvm选择哪一个线程运行 运行多长时间 是程序员不可控的
        //哪一个线程先被执行 和start顺序无关 也和线程对象的创建时间无关
        //之和jvm有关
        fr1.start();
        fr2.start();
        fr3.start();

        //fr1.run(); fr1只是一个对象  run()只是一个方法  不可视作一个线程  不具备线程的特性
        fr1.run();
    }
}

