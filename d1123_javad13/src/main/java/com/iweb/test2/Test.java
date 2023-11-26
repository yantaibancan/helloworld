package com.iweb.test2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yiyu
 * @date 2023/11/23 18:09
 */
public class Test {
    private static String now()
    {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
    private static void log(String msg)
    {
        System.out.printf("%s %s %s %n",now(),Thread.currentThread().getName(),msg);
    }
    public static void main(String[] args) {
        //悲观锁的另一种实现方式  ReentrantLock
        //锁的获取和释放是通过方法调用实现的
        // Lock lock = new ReentrantLock();
        // Thread t1 = new Thread(){
        //     @Override
        //     public void run() {
        //         log("线程启动");
        //         log("试图获取锁");
        //         //线程获取锁
        //         lock.lock();
        //         log("获取到对象锁");
        //         log("模拟五秒的业务操作");
        //         try {
        //             Thread.sleep(5000);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         } finally {
        //             log("释放锁");
        //             lock.unlock();
        //         }
        //         log("线程运行结束");
        //     }
        // };
        // t1.setName("t1");
        // t1.start();
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        //
        // Thread t2 = new Thread(){
        //     @Override
        //     public void run() {
        //         log("线程启动");
        //         log("试图获取锁");
        //         //线程获取锁
        //         lock.lock();
        //         log("获取到对象锁");
        //         log("模拟五秒的业务操作");
        //         try {
        //             Thread.sleep(5000);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         } finally {
        //             log("释放锁");
        //             lock.unlock();
        //         }
        //         log("线程运行结束");
        //     }
        // };
        // t2.setName("t2");
        // t2.start();

        //使用synchronized进行线程调度 使用的是wait notify notifyAll 方法
        //Lock 提供了类似的方法 先通过lock对象获取一个Condition对象
        //调用该对象的await signal signalAll 方法
        // Lock lock = new ReentrantLock();
        // Condition condition = lock.newCondition();
        // Thread t1 = new Thread(){
        //     @Override
        //     public void run() {
        //         try{
        //             log("线程启动");
        //             log("试图获取锁");
        //             lock.lock();
        //             log("成功获取到锁");
        //             log("5秒业务操作模拟");
        //             Thread.sleep(5000);
        //             log("调用await方法临时释放锁 并进入到等待状态");
        //             condition.await();
        //             log("重写获取锁 并且再进行5s的模拟业务操作");
        //             Thread.sleep(5000);
        //         }catch (Exception e)
        //         {
        //             e.printStackTrace();
        //         } finally {
        //             log("释放锁");
        //             lock.unlock();
        //         }
        //     }
        // };
        // t1.setName("t1");
        // t1.start();
        //
        // Thread t2 = new Thread(){
        //     @Override
        //     public void run() {
        //         try{
        //             log("线程启动");
        //             log("试图获取锁");
        //             lock.lock();
        //             log("获取到锁");
        //             log("模拟5s业务操作");
        //             Thread.sleep(5000);
        //             log("唤醒处于wait状态的线程");
        //             condition.signal();
        //         } catch (Exception e)
        //         {
        //             e.printStackTrace();
        //         } finally {
        //             log("释放锁");
        //             lock.unlock();
        //         }
        //         log("线程结束");
        //     }
        // };
        // t2.setName("t2");
        // t2.start();

        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(){
            boolean locked = false;
            @Override
            public void run() {
                try {
                    log("线程启动");
                    log("试图获取锁");
                    //线程会试图获取锁 但是只获得1s
                    //如果获取到了 则方法返回值返回true
                    //如果获取不到 则返回false 并且放弃获取 直接执行后续代码
                    locked = lock.tryLock(1, TimeUnit.SECONDS);
                    if(locked)
                    {
                        log("成功获取锁");
                        log("sleep模拟5s业务");
                        Thread.sleep(5000);
                    }else {
                        log("经过1s的尝试，没有获取锁");
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                } finally {
                    if(locked)
                    {
                        log("释放锁");
                        lock.unlock();
                    }
                }

            }
        };
        t1.setName("t1");
        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(){
            boolean locked = false;
            @Override
            public void run() {
                try {
                    log("线程启动");
                    log("试图获取锁");
                    //线程会试图获取锁 但是只获得1s
                    //如果获取到了 则方法返回值返回true
                    //如果获取不到 则返回false 并且放弃获取 直接执行后续代码
                    locked = lock.tryLock(1, TimeUnit.SECONDS);
                    if(locked)
                    {
                        log("成功获取锁");
                        log("sleep模拟5s业务");
                        Thread.sleep(5000);
                    }else {
                        log("经过1s的尝试，没有获取锁");
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                } finally {
                    if(locked)
                    {
                        log("释放锁");
                        lock.unlock();
                    }
                }

            }
        };
        t2.setName("t2");
        t2.start();

        //ReentrantLock和synchronized区别
        //1.Lock本质是一个接口  而ReentrantLock和synchronized区别是一个关键字
        //synchronized是内置的语言实现 Lock是代码层面的实现
        //2.Lock可以选择性的获取锁 如果一段时间内获取不到 就会放弃
        //synchronized不可以 所以可以利用tryLock的特性有效避免死锁
        //而synchronized必须通过谨慎和良好的设计才能减少死锁的发生
        //3.synchronized在发生异常或者是让同步代码块结束运行的时候自动释放锁
        //而Lock接口必须通过调用unlock方法手动释放锁
        //如果忘记释放锁 一样会有死锁

        //原子操作  不可以被线程中断的操作
        int a = 1;
        System.out.println(" ");
        //java中提供了一些类 叫做原子类
        //原子类的所有操作都是线程安全的(具有原子性)
        AtomicInteger ai = new AtomicInteger();
        ConcurrentHashMap chm = new ConcurrentHashMap();
        //HashTable 保证线程安全 使用的是synchronized关键字 是悲观锁
        //ConcurrentHashMap 在jdk1.7使用的是分段式Segment 在jdk1.8使用的是自旋锁
        //自旋锁的本质是一个死循环 一直尝试获取锁
        //如果获取锁的时候，锁被其他线程所持有
        //通过循环，在下一次继续尝试获取 可以有效避免阻塞

    }
}
