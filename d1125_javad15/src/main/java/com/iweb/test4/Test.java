package com.iweb.test4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author yiyu
 * @date 2023/11/25 11:19
 */
public class Test {

    public static Connection getConnection() throws Exception {
        File springConfigFile = new File("D:\\idea_workspace\\d1115_javad11\\d1125_javad15\\src\\main\\java\\com\\iweb\\test4\\db.properties");
        Properties springConfig = new Properties();
        springConfig.load(new FileInputStream(springConfigFile));
        String url = (String) springConfig.get("url");
        String username = (String) springConfig.get("username");
        String password = (String) springConfig.get("password");
        // System.out.println(url);
        // System.out.println(username);
        // System.out.println(password);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(DBUtil.getDataSource().getConn());


    }
}
