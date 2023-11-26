package com.iweb.homework.homework5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yiyu
 * @date 2023/11/20 18:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player extends Thread{
    String playerName;
    BulletinBoard bulletinBoard;

    @Override
    public void run() {
        while(true)
        {
            bulletinBoard.pickUpTask(this);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
