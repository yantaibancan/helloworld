package com.iweb.test;

/**
 * @author yiyu
 * @date 2023/11/22 18:27
 */
public class Test {
    //静态方法的同步对象是当前类所对应的class对象
    public synchronized static void li()
    {

    }
    //li()等价于l()
    //每一个类的反射对象，全局唯一
    public synchronized static void l()
    {
        synchronized (Test.class)
        {

        }
    }

    public static void main(String[] args) {
        //
    }
}
