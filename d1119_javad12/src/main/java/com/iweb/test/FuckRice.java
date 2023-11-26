package com.iweb.test;

/** 实现Runnable接口
 * @author yiyu
 * @date 2023/11/19 9:18
 */
public class FuckRice implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("嫂子别回头，我是:"+Thread.currentThread().getName());
        }
    }
}
