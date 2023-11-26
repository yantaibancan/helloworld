package com.iweb.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yiyu
 * @date 2023/11/23 22:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Homework1 {
    private int a;
    public static void main(String[] args) {
        Homework1 homework1 = new Homework1(0);
        for (int i = 0; i < 500; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    synchronized (homework1)
                    {
                        homework1.setA(homework1.getA()+1);
                    }
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
                    synchronized (homework1)
                    {
                        homework1.setA(homework1.getA()-1);
                    }
                }
            };

            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println(homework1.getA());
    }
}
