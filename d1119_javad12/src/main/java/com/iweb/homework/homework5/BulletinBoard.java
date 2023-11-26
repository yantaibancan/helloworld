package com.iweb.homework.homework5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/20 18:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BulletinBoard {
    private List<Task> tasks = new ArrayList<>();

    public synchronized void addTask(Task task)
    {
        if(tasks.size()<20)
        {
            tasks.add(task);
            System.out.println("NPC发布了任务，现在有"+tasks.size()+"个任务");
            this.notifyAll();
        }
    }

    public synchronized void pickUpTask(Player player)
    {
        while (tasks.isEmpty())
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Task tmpTask = tasks.get(tasks.size()-1);
        tasks.remove(tasks.size()-1);
        System.out.println("任务"+tmpTask.getDescription()+"被"+player.getPlayerName()+"接走了,剩余"+tasks.size()+"个任务");

        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
