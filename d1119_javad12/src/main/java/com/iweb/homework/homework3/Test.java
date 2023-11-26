package com.iweb.homework.homework3;

/**
 * @author yiyu
 * @date 2023/11/20 11:21
 */
public class Test {
    public static void main(String[] args) {
        Basket basket = new Basket();

        Kun kun = new Kun(basket);
        kun.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            LittleBlackMan littleBlackMan = new LittleBlackMan("小黑子"+i,basket);
            littleBlackMan.start();
        }
    }
}
