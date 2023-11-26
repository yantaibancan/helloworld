package com.iweb.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yiyu
 * @date 2023/11/23 22:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Homework3 {
    private volatile AtomicInteger a;

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        Homework3 homework3 = new Homework3(ai);

        for (int i = 0; i < 500; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    homework3.getA().getAndIncrement();
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
            Thread t = new Thread(){
                @Override
                public void run() {
                    homework3.getA().getAndDecrement();
                }
            };
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(homework3.getA());
    }
}
