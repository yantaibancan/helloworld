package com.iweb.test;

/** 反射 和注解
 * 将java的类当作是一种对象  类对象
 * @author yiyu
 * @date 2023/11/25 9:03
 */
public class Test {
    static {
        System.out.println("静态属性被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //三种方式获取类的类对象
        //1.调用Class.forName获取
        Class c1 = Class.forName("com.iweb.test.Test");
        //2.利用类对象所对应的类的实例获取
        Class c2 = new Test().getClass();
        //3.使用.class直接获取
        Class c3 = Test.class;
        //类对象再同一个jvm中 不管获取多少次 获取的
        //永远是同一个(类加载只会进行一次 而类对象会在类加载的时候自动创建)
        System.out.println(c1==c2);
        System.out.println(c1==c3);
        //类对象获取的时候 会自动加载类对象的静态属性
        //.class方式获取类信息的时候 是不会加载类的静态属性的
    }
}
