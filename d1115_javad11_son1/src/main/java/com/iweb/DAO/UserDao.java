package com.iweb.DAO;

import com.iweb.entity.User;

import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/16 10:52
 */
public interface UserDao {
    User listById(Integer id);
    void insert(User user);

    void update(User user);
}
