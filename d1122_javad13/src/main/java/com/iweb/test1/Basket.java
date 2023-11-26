package com.iweb.test1;

/**定义一个篮子类，用来装馒头
 * 篮子是有容量的 篮子需要有一个变量来表示容量 和当前篮子中馒头的情况
 * 还需要对外提供装馒头和取馒头的方法
 * @author yiyu
 * @date 2023/11/22 18:39
 */
public class Basket {
    int index = 0;
    //定义容器
    ManTou[] arrMT = new ManTou[6];
    //装馒头方法
    public synchronized void push(ManTou mt)
    {
        //如果篮子满了，希望能够通知装馒头的线程等待
        while(index==arrMT.length)
        {
            System.out.println("篮子满了");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果取馒头的线程wait了，则通知取馒头的线程醒来
        this.notifyAll();
        //将当前的馒头对象存放在篮子容器中
        arrMT[index++] = mt;
    }

    public synchronized ManTou pop()
    {
        //篮子空了
        while (index==0)
        {
            System.out.println("篮子空了");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果装馒头的wait了，则通知醒来
        this.notifyAll();
        return arrMT[--index];
    }
}
