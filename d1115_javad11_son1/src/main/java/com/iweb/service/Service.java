package com.iweb.service;

import com.iweb.DAO.UserDao;
import com.iweb.DAO.impl.UserDaoImpl;
import com.iweb.entity.User;

import java.util.Scanner;

import static com.iweb.util.UserData.currentLoginUser;

/**
 * @author yiyu
 * @date 2023/11/16 10:50
 */
public class Service {
    static Scanner sc = new Scanner(System.in);

    public static boolean login(User InputLoginUser)
    {
        boolean flag=false;
        UserDao userDao = new UserDaoImpl();
        User user = userDao.listById(InputLoginUser.getId());
        if(InputLoginUser.equals(user))
        {
            flag = true;
            currentLoginUser = user;
        }
        return flag;
    }


    public static boolean register(User inputRegisterUser)
    {
        boolean flag=true;
        UserDao userDao = new UserDaoImpl();
        User user = userDao.listById(inputRegisterUser.getId());
        if(!(user==null))
        {
            flag = false;
        }


        return flag;
    }
}
