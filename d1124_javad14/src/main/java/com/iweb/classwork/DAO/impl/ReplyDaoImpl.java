package com.iweb.classwork.DAO.impl;

import com.iweb.classwork.DAO.ReplyDao;
import com.iweb.classwork.entity.Reply;
import com.iweb.classwork.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/24 16:13
 */
public class ReplyDaoImpl implements ReplyDao {

    @Override
    public List<Reply> listByReceiveLike(String receive) {
        List<Reply> replyList = new ArrayList<>();
        String sql = "select * from reply where receive like concat('%',?,'%')";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                )
        {
            ps.setString(1,receive);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                Reply reply = new Reply();
                reply.setId(rs.getInt("id"));
                reply.setReceive(rs.getString("receive"));
                reply.setResponse(rs.getString("response"));
                replyList.add(reply);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return replyList.isEmpty()?listByReceiveLike("default"):replyList;
    }
}
