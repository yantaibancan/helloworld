package com.iweb.test3;

/**
 * @author yiyu
 * @date 2023/11/23 20:14
 */
public class Lyh extends Thread{
    private boolean flag = false;
    public boolean isFlag()
    {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag的值为"+flag);
    }
}
