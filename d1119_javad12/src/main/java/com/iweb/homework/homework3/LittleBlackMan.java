package com.iweb.homework.homework3;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yiyu
 * @date 2023/11/20 11:04
 */
@Data
@NoArgsConstructor
public class LittleBlackMan extends Thread{
    private String blackName;
    private Basket basket = new Basket();

    public LittleBlackMan(String blackName, Basket basket)
    {
        this.blackName=blackName;
        this.basket=basket;
    }

    public void takeEggs()
    {
        while(true)
        {
            basket.takeEggs(this);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // System.out.println(blackName+"拿出了一个蛋,蛋的数量为"+basket.getEggs().size());
        }

    }

    @Override
    public void run() {
        takeEggs();
    }
}
