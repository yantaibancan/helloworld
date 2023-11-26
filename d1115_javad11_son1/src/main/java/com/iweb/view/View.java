package com.iweb.view;

import com.iweb.controller.Controller;
import com.iweb.entity.User;

import java.util.Scanner;

import static com.iweb.controller.Controller.updateUserInfoController;
import static com.iweb.controller.Controller.userInfoController;
import static com.iweb.util.Log.log;
import static com.iweb.util.UserData.currentLoginUser;

/**
 * @author yiyu
 * @date 2023/11/16 10:48
 */
public class View {
    static Scanner sc = new Scanner(System.in);
    public static void mainView()
    {
        log("欢迎进入用户登录系统");
        log("===============================");
        log("请输入您要操作的业务");
        log("1.登录");
        log("2.注册");
        log("3.退出");
        String inputKey=sc.nextLine();
        // TODO:
        Controller.mainController(inputKey);
    }

    public static User loginView()
    {
        log("请输入您的账号id:");
        int inputUserID=Integer.parseInt(sc.nextLine());
        log("请输入您的密码:");
        String inputPassword=sc.nextLine();
        //对用户输入的数据进行封装
        User inputUser = new User();
        inputUser.setId(inputUserID);
        inputUser.setPassword(inputPassword);
        return inputUser;
    }

    public static void userInfoView()
    {
        log("请输入您要操作的功能序号");
        log("1.查看用户信息");
        log("2.修改用户信息");
        log("3.退出当前用户");
        // TODO: 2023/11/10 后续调用逻辑
        String inputKey=sc.nextLine();
        userInfoController(inputKey);
    }

    public static void showUserInfoView()
    {
        int id = currentLoginUser.getId();
        String password = currentLoginUser.getPassword();
        String userName = currentLoginUser.getUserName();
        log("id:"+id);
        log("password:"+password);
        log("userName:"+userName);
    }

    public static void updateUserInfoView()
    {
        log("1.修改用户昵称");
        log("2.修改用户密码");
        log("3.返回上一级");
        // TODO: 2023/11/13 进入修改用户信息的业务
        String inputKey=sc.nextLine();
        updateUserInfoController(inputKey);
    }

    public static String updateUserNameView()
    {
        log("请输入修改后的昵称");
        String inputUserName = sc.nextLine();
        return inputUserName;
    }

    public static String updatePasswordView()
    {
        log("请输入修改后的密码");
        String inputPassword = sc.nextLine();
        return inputPassword;
    }

    public static User registerView()
    {
        log("请输入您的账号id:");
        int inputUserId=Integer.parseInt(sc.nextLine());
        log("请输入您的密码:");
        String inputPassword=sc.nextLine();
        log("请输入您的昵称");
        String userName=sc.nextLine();
        //对用户输入的数据进行封装
        User inputUser = new User();
        inputUser.setId(inputUserId);
        inputUser.setPassword(inputPassword);
        inputUser.setUserName(userName);
        return inputUser;

    }
}
