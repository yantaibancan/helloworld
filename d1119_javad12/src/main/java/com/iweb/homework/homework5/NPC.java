package com.iweb.homework.homework5;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yiyu
 * @date 2023/11/20 18:26
 */
@Data
@NoArgsConstructor
public class NPC extends Thread{
    private BulletinBoard bulletinBoard;
    private int count;

    public NPC(BulletinBoard bulletinBoard)
    {
        this.bulletinBoard=bulletinBoard;
    }

    @Override
    public void run() {
        while (true)
        {
            Task task = new Task("任务"+count);
            count+=1;
            bulletinBoard.addTask(task);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
