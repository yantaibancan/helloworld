package com.iweb.test4;

/** volatile禁止指令重排序
 * 设计模式 单类模式
 * 1.私有构造方法
 * 2.本类自己的静态引用
 * 3.公共的获取实例方法
 *
 * @author yiyu
 * @date 2023/11/24 13:52
 */
public class Test {
//java中有指令重排序
    //创建对象
    //1.new向堆申请空间 2.通过构造方法完成初始化 3.返回引用
    //1.new向堆申请空间 2.返回引用 3.通过构造方法完成初始化
    //被volatile修饰的变量禁止指令重排序

}
