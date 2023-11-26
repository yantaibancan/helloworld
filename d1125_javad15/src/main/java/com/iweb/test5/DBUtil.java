package com.iweb.test5;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author yiyu
 * @date 2023/11/25 14:15
 */
@JDBCConfig(url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8",
        username="root",password="a12345")
public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        //获取当前贴在类上的注解对象
        JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);
        //Field 成员变量的反射对象
        //Parameter 方法参数的反射对象
        String url = config.url();
        String username = config.username();
        String password = config.password();
        return DriverManager.getConnection(url,username,password);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getConnection());
    }
}


