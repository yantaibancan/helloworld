package com.iweb.test3;

import lombok.Data;

/**
 * @author yiyu
 * @date 2023/11/19 14:27
 */
@Data
public class Monster {
    private String name;
    private float hp;

    //synchronized如果用来修饰实例方法，同步对象就是当前对象this
    public synchronized void recover()
    {
        //1.先获取hp  2.计算hp+1  3.对hp赋值
        hp++;
    }

    public void hurt()
    {
        //同步对象由后面括号决定 可以是其他对象
        synchronized (this)
        {
            hp--;
        }
    }
}
