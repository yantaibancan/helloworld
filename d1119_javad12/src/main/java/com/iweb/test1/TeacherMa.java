package com.iweb.test1;

import lombok.Data;

/**
 * @author yiyu
 * @date 2023/11/19 11:39
 */
@Data
public class TeacherMa extends Thread{
    private Hercules marble;


    public void cd(int ms)
    {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean test()
    {
        if(marble.getCount()<=10)
        {
            return true;
        }
        return false;
    }
    @Override
    public void run() {
        loop:while (true)
        {
            System.out.println("接");
            cd(1000);
            if(test())
            {
                break loop;
            }
            System.out.println("化");
            cd(1000);
            if(test())
            {
                break loop;
            }
            System.out.println("发");
            cd(1000);
            if(test())
            {
                break loop;
            }
            System.out.println("闪电五连鞭");
            cd(2000);
            if(test())
            {
                break loop;
            }
        }
        System.out.println("不讲武德");

    }
}
