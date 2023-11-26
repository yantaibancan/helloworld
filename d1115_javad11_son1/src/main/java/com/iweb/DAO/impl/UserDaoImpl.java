package com.iweb.DAO.impl;

import com.iweb.DAO.UserDao;
import com.iweb.entity.User;
import com.iweb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author yiyu
 * @date 2023/11/16 10:53
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User listById(Integer id) {
        User user = null;
        String sql = "select * from user where id=?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                )
        {
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setPassword(rs.getString("password"));
                user.setUserName(rs.getString("username"));
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user==null?null:user;
    }

    @Override
    public void insert(User user) {
        String sql = "insert into user values (?,?,?)";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                )
        {
            ps.setInt(1,user.getId());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getUserName());
            ps.execute();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void update(User user) {
        String sql = "update user set password=?,username=? where id=?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                )
        {
            ps.setString(1,user.getPassword());
            ps.setString(2,user.getUserName());
            ps.setInt(3,user.getId());
            ps.execute();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
