package com.iweb.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yiyu
 * @date 2023/11/23 22:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Homework2 {
    private int a;

    public static void main(String[] args) {
        Homework2 homework2 = new Homework2(0);
        Lock lock = new ReentrantLock();

        for (int i = 0; i < 500; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    lock.lock();
                    homework2.setA(homework2.getA() + 1);
                    lock.unlock();
                }
            };
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 500; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    lock.lock();
                    homework2.setA(homework2.getA() - 1);
                    lock.unlock();
                }
            };
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(homework2.getA());
    }
}
