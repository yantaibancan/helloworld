package com.iweb.homework.homework5;

/**
 * @author yiyu
 * @date 2023/11/20 18:37
 */
public class Test {
    public static void main(String[] args) {
        BulletinBoard bulletinBoard = new BulletinBoard();
        NPC npc = new NPC(bulletinBoard);
        npc.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            Player player = new Player("玩家"+i,bulletinBoard);
            player.start();
        }

    }
}
