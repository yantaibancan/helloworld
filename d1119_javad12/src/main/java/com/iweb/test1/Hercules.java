package com.iweb.test1;

import lombok.Data;

import java.util.Random;

/**
 * @author yiyu
 * @date 2023/11/19 11:40
 */
@Data
public class Hercules extends Thread{
    private int count = 100;

    public void run()
    {
        Random r = new Random();
        while (true)
        {
            count=r.nextInt(100)+1;
            if(count>10)
            {
                System.out.println("大理石出手了，大理石failed");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
