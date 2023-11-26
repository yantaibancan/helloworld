package com.iweb.test5;

/** 注解 @Override
 * 标签纸
 * 注解类--标签纸模板  决定了能够有哪些属性
 * 注解对象--写好了内容的标签纸
 * 注解必须结合代码才有实际意义
 * 注解理论上可以出现在类 方法 成员变量等几乎所有位置
 * 注解本质也是一个类 @interface
 * 注解有三类
 * 1.内置注解  jdk自带注解
 * @Override
 * @Deprecated
 * @SuppressWarnings 警告抑制  用来忽略警告信息
 * deprecation  使用了不赞成使用的类或方法的警告
 * unchecked 执行了未检查的转换时候的警告(集合不使用泛型)
 * fallthrough switch代码块没有写break的警告
 * path 类或者源文件路径中有不存在时候的警告
 * serial 当在可序列化的类上缺少serialVersionUID时候的警告
 * finally 任何finally自居不能正常完成时候的警告
 * rawtypes 泛型类型未指明
 * unused 定义了引用，但是没有声明
 * all 以上所有
 * @FunctionalInterface 函数式接口
 * 2.元注解 用来注解注解的注解
 * 3.自定义注解 开发者自己定义的注解
 * @author yiyu
 * @date 2023/11/25 13:44
 */
public class Test {

    public static void main(String[] args) {

    }
}
