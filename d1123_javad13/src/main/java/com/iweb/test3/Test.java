package com.iweb.test3;

/**
 * JMM java内存模型 java虚拟机规范中所定义的一种内存模型
 * 为了屏蔽底层不同的计算机区别
 * 计算机的内存模型  高速缓存  作为内存和CPU之间的缓冲
 * 将运算需要使用到的数据复制到缓存中
 * 让运算能快速进行  等运算结束之后
 * 再从缓存中同步回内存中
 * CPU就不需要再等待内存读写完成之后再继续运行指令了
 * 在多核CPU出现之后 引入了一个新的问题  缓存一致性问题
 * 多CPU系统中 每个CPU都有自己的高速缓存
 * 而所有CPU又共享同一个主内存
 * 必须遵循一个协议  叫做一致性协议.0
 * @author yiyu
 * @date 2023/11/23 20:12
 */
public class Test {
    //volatile
    //1.保证变量的可见性
    //2.禁止指令重排序
    public static void main(String[] args) {
        Lyh ldt = new Lyh();
        ldt.start();
        while (true)
        {
            synchronized (ldt)
            {
                if(ldt.isFlag())
                {
                    System.out.println("发现flag的值变化了");
                    break;
                }
            }

        }
    }

}
