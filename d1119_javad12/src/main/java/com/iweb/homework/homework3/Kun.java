package com.iweb.homework.homework3;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yiyu
 * @date 2023/11/20 10:58
 */
@Data
@NoArgsConstructor
public class Kun extends Thread{

    private Basket basket;
    private int count;
    public Kun(Basket basket)
    {
        this.basket=basket;
        count=0;
    }
    @Override
    public void run() {
        while (true)
        {
            Egg egg = new Egg(count);
            count+=1;
            basket.addEggs(egg);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }



}
