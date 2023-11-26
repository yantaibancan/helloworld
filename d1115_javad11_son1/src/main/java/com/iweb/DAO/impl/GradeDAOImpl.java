package com.iweb.DAO.impl;

import com.iweb.DAO.GradeDAO;
import com.iweb.entity.Grade;
import com.iweb.util.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/15 18:29
 */
public class GradeDAOImpl implements GradeDAO {
    @Override
    public List<Grade> listBySid(Integer sid) {
        List<Grade> grades = new ArrayList<>();
        String sql = "select * from grade where sid=?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                )
        {
            ps.setInt(1,sid);

            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Grade grade = new Grade();

                Integer id = rs.getInt("id");
                String subject = rs.getString("subject");
                BigDecimal degree = rs.getBigDecimal("degree");
                Integer ssid = rs.getInt("sid");

                grade.setId(id);
                grade.setSubject(subject);
                grade.setDegree(degree);
                grade.setSid(ssid);
                grades.add(grade);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return grades.isEmpty()?null:grades;
    }
}
