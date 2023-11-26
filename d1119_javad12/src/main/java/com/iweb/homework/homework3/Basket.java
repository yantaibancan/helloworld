package com.iweb.homework.homework3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/20 10:44
 */
@Data
@AllArgsConstructor
public class Basket {
    private List<Egg> eggs = new ArrayList<>();

    public Basket()
    {
        // eggs.add(new Egg(0));
        // eggs.clear();
    }
    public synchronized void addEggs(Egg egg)
    {
        if(eggs.size()<10)
        {
            eggs.add(egg);
            System.out.println("哥哥下蛋了，现在有"+eggs.size()+"个蛋");
            this.notifyAll();
        }
    }

    public synchronized void takeEggs(LittleBlackMan littleBlackMan)
    {

        while (eggs.isEmpty())
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


            eggs.remove(eggs.size()-1);
            System.out.println("蛋被"+littleBlackMan.getBlackName()+"拿走了一个，现在有"+eggs.size()+"个蛋");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }







    }

}
