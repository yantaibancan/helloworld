package com.iweb.controller;

import com.iweb.DAO.UserDao;
import com.iweb.DAO.impl.UserDaoImpl;
import com.iweb.entity.User;
import com.iweb.service.Service;
import com.iweb.view.View;

import static com.iweb.util.Log.log;
import static com.iweb.util.UserData.currentLoginUser;
import static com.iweb.view.View.*;

/**
 * @author yiyu
 * @date 2023/11/16 10:49
 */
public class Controller {
    public static void mainController(String key)
    {
        UserDao userDao = new UserDaoImpl();
        switch (key){
            case "1":
                // TODO: 2023/11/10  调用登录相关业务
                User inputLoginUser = View.loginView();
                boolean login= Service.login(inputLoginUser);
                //根据登录逻辑调用的结果 决定下一步跳转的视图
                if(login)
                {
                    //跳转到下一个视图
                    userInfoView();
                }
                else
                {
                    log("用户名或密码有误,或验证码有误,请重新输入");
                    mainView();
                    return;
                }
                break;
            case "2":
                // TODO: 2023/11/10 调用注册相关业务
                User inputRegisterUser = View.registerView();
                boolean register = Service.register(inputRegisterUser);
                if(register)
                {
                    log("注册成功");
                   userDao.insert(inputRegisterUser);
                   View.mainView();
                }
                else
                {
                    log("注册失败，此用户已存在");
                    View.mainView();
                    return;
                }
                break;
            default:
                System.exit(0);
        }

    }

    public static void userInfoController(String key)
    {
        switch (key)
        {
            case "1":
                showUserInfoView();
                userInfoView();
                break;
            case "2":
                updateUserInfoView();
                userInfoView();
                break;
            default:
                currentLoginUser = null;
                mainView();
                break;
        }
    }


    public static void updateUserInfoController(String key)
    {
        UserDao userDao = new UserDaoImpl();
        switch (key)
        {
            case "1":
                String name = updateUserNameView();
                User tmp = new User();
                tmp.setId(currentLoginUser.getId());
                tmp.setPassword(currentLoginUser.getPassword());
                tmp.setUserName(name);
                userDao.update(tmp);
                currentLoginUser=tmp;
                updateUserInfoView();

                break;
            case "2":
                String password = updatePasswordView();
                User tmp1 = new User();
                tmp1.setId(currentLoginUser.getId());
                tmp1.setPassword(password);
                tmp1.setUserName(currentLoginUser.getUserName());
                userDao.update(tmp1);
                currentLoginUser=tmp1;
                updateUserInfoView();
                break;
            default:
                userInfoView();
                break;
        }
    }



}



