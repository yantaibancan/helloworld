package com.iweb.test3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/** 反射核心体现在spring
 * IOC 控制反转
 * DI 依赖注入
 * @author yiyu
 * @date 2023/11/25 10:58
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //从配置文件中提取所需要的信息
        File springConfigFile = new File("D:\\idea_workspace\\d1115_javad11\\d1125_javad15\\src\\main\\java\\com\\iweb\\test3\\spring.properties");
        //不再使用原生IO流读取 而是使用java提供的Properties类进行读取
        Properties springConfig = new Properties();
        //工具类加载配置文件
        springConfig.load(new FileInputStream(springConfigFile));
        //工具类会自动提取所有的配置文件信息 并封装成map
        //我们只需要通过get方式获取配置文件信息即可
        String className = (String) springConfig.get("className");
        String methodName = (String) springConfig.get("methodName");
        Class uClass = Class.forName(className);
        Method m = uClass.getMethod(methodName);
        Constructor<UserService> c = uClass.getConstructor();
        //实例化对象完成方法调用
        m.invoke(c.newInstance());
    }
}
