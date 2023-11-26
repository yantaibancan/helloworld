package com.iweb.DAO.impl;

import com.iweb.DAO.GradeDAO;
import com.iweb.DAO.StudentDAO;
import com.iweb.entity.Student;
import com.iweb.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yiyu
 * @date 2023/11/14 20:04
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public void insert(Student student) {
        // String sql="insert into student(NAME,gender,birthday,address,qqnumber) values('"
        //         +student.getName()+"','"+student.getGender()+"','"+new SimpleDateFormat("yyyy-MM-dd").format(student.getBirthday()) +"','"
        //         +student.getAddress()+"',"+student.getQqnumber()+")";
        // try(Connection c = DBUtil.getConnection();
        //     Statement s = c.createStatement();){
        //     s.execute(sql);
        // }catch (SQLException e)
        // {
        //     e.printStackTrace();
        // }


        //Statement存在几种弊端
        //1.参数较多的时候 拼接比较恶心
        //2.statement是先传参 再编译 性能较差
        //3.statement存在SQL注入攻击的问题

        //PreparedStatement
        //1.参数传递简单 方法调用传递即可
        //2.先编译，再传参 性能更好
        //3.不存在sql注入攻击的问题 在参数传入之前 语句已经编译确定了
        //  传递的参数只会被当作字符串识别

        String sql = "insert into student(name,gender,birthday,address,qqnumber)"+
                "values(?,?,?,?,?)";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                )
        {
            //使用方法进行传参 用序号代表所传递参数问号的位置 这里是java中为数不多的基1的参数传递
            ps.setString(1,student.getName());
            ps.setString(2,student.getGender());
            ps.setDate(3, new Date(student.getBirthday().getTime()));
            ps.setString(4,student.getAddress());
            ps.setLong(5,student.getQqnumber());
            ps.execute();
            //在执行完插入语句之后 mysql会为新增的数据分配一个自增长id
            //jdbc可以通过getGeneratedKeys方法获取id
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                student.setId(rs.getInt(1));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //由于没有写 c.setAutoCommit(false);
    //所有的dml语句默认自动commit提交 不需要我们进行事务管理
    //如果写了c.setAutoCommit(false); 需要在方法的最后手动调用c.commit()
    //c.setSavepoint()和c.rollback()进行存档点的设置和事务的问题
    @Override
    public void delete(Integer id) {
        String sql="delete from student where id="+id;
        try(Connection c = DBUtil.getConnection();
            Statement s = c.createStatement();)
        {
            s.execute(sql);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        String sql = "update student set name=?,gender=?,birthday=?,address=?,qqnumber=? where id=?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                )
        {
            ps.setString(1,student.getName());
            ps.setString(2,student.getGender());
            ps.setDate(3,new Date(student.getBirthday().getTime()));
            ps.setString(4,student.getAddress());
            ps.setLong(5,student.getQqnumber());
            ps.setInt(6,student.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Student> listAll() {
        return listByPage(null,0,Integer.MAX_VALUE);
    }

    @Override
    public List<Student> listByNameLike(String key) {
        List<Student> stus= new ArrayList<>();
        String sql = "select * from student where name like concat('%',?,'%')";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ){
            ps.setString(1,key);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Student s =new Student();
                //从结果集遍历当前行中 将每一个字段的值单独取出
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                Date birthday = rs.getDate("birthday");
                String address = rs.getString("address");
                Long qqnumber = rs.getLong("qqnumber");
                s.setId(id);
                s.setName(name);
                s.setGender(gender);
                s.setBirthday(birthday);
                s.setAddress(address);
                s.setQqnumber(qqnumber);
                stus.add(s);
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return stus.isEmpty()?null:stus;
    }

    @Override
    public List<Student> listByPage(Integer start, Integer count) {
        return listByPage(null,start,count);
    }

    @Override
    public List<Student> listByPage(String key, Integer start, Integer count) {
        List<Student> stus= new ArrayList<>();
        String sql;
        if(key==null || key=="")
        {
            sql = "select * from student limit ?,?";
        }
        else
        {
            sql = "select * from student where name like concat('%',?,'%') limit ?,?";
        }
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ){
            if(key==null || key=="")
            {
                ps.setInt(1,start);
                ps.setInt(2,count);
            }
            else
            {
                ps.setString(1,key);
                ps.setInt(2,start);
                ps.setInt(3,count);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Student s =new Student();
                //从结果集遍历当前行中 将每一个字段的值单独取出
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                Date birthday = rs.getDate("birthday");
                String address = rs.getString("address");
                Long qqnumber = rs.getLong("qqnumber");
                s.setId(id);
                s.setName(name);
                s.setGender(gender);
                s.setBirthday(birthday);
                s.setAddress(address);
                s.setQqnumber(qqnumber);
                stus.add(s);
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return stus.isEmpty()?null:stus;

    }

    @Override
    public void testInsert() {
        String sql = "insert into student values(?,?,?,?,?,?)";
        Connection c = null;
        try {
            c = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(
                PreparedStatement ps = c.prepareStatement(sql);
                )
        {
            //关闭事务自动提交
            c.setAutoCommit(false);
            Random r = new Random();
            for (int i = 0; i < 10000; i++) {
                ps.setInt(1,r.nextInt(200)+11);
                ps.setString(2,"学生"+i);
                ps.setString(3,"男");
                ps.setDate(4,new Date(new java.util.Date().getTime()));
                ps.setString(5,"南京");
                ps.setLong(6,r.nextInt(1000000)+10000);
                ps.execute();
            }
            c.commit();
        }catch (SQLException e)
        {
            try {
                System.out.println("插入发生错误，事务自动回滚");
                c.rollback();
            } catch (SQLException ex) {
               e.printStackTrace();
            }
        }
    }

    @Override
    public Student listByIdWithGrade(Integer id) {
        Student stu = new Student();
        GradeDAO gradeDAO = new GradeDAOImpl();
        String sql = "select * from student where id=?";
        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        )
        {

            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                //从结果集遍历当前行中 将每一个字段的值单独取出
                Integer iid = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                Date birthday = rs.getDate("birthday");
                String address = rs.getString("address");
                Long qqnumber = rs.getLong("qqnumber");
                stu.setId(iid);
                stu.setName(name);
                stu.setGender(gender);
                stu.setBirthday(birthday);
                stu.setAddress(address);
                stu.setQqnumber(qqnumber);
                stu.setGrades(gradeDAO.listBySid(id));
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return stu;

    }

    @Override
    public List<Student> listAllWithGrade() {
        return listAllWithGrade(0,Integer.MAX_VALUE);
    }

    @Override
    public List<Student> listAllWithGrade(int start, int count) {
        List<Student> stus = new ArrayList<>();
        GradeDAO gradeDAO = new GradeDAOImpl();
        String sql = "select * from student limit ?,?";

        try(
                Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
                )
        {

            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Student s =new Student();
                //从结果集遍历当前行中 将每一个字段的值单独取出
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                Date birthday = rs.getDate("birthday");
                String address = rs.getString("address");
                Long qqnumber = rs.getLong("qqnumber");
                s.setId(id);
                s.setName(name);
                s.setGender(gender);
                s.setBirthday(birthday);
                s.setAddress(address);
                s.setQqnumber(qqnumber);
                s.setGrades(gradeDAO.listBySid(id));
                stus.add(s);
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return stus.isEmpty()?null:stus;
    }


}
