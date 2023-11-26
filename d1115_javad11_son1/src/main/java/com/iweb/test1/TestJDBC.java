package com.iweb.test1;

import com.iweb.DAO.GradeDAO;
import com.iweb.DAO.StudentDAO;
import com.iweb.DAO.UserDao;
import com.iweb.DAO.impl.GradeDAOImpl;
import com.iweb.DAO.impl.StudentDAOImpl;
import com.iweb.DAO.impl.UserDaoImpl;
import com.iweb.entity.User;
import com.iweb.service.Service;

import static com.iweb.view.View.mainView;

/**
 * ORM object relation model 对象映射关系模型
 * @author yiyu
 * @date 2023/11/14 18:33
 */
public class TestJDBC {
    public static void main(String[] args) {
        //驱动加载
        // try {
        //     Class.forName("com.mysql.jdbc.Driver");
        // } catch (ClassNotFoundException e) {
        //     e.printStackTrace();
        // }
        // System.out.println("驱动加载成功");
        //
        // //连接创建
        // String username = "root";
        // String password = "a12345";
        // String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf8";

        //编译语句的创建
        // try(//Connection c= DriverManager.getConnection(url,username,password);
        //     Connection c = DBUtil.getConnection();
        //     Statement s =c.createStatement();)
        // {
        //     String sql = "INSERT INTO student(NAME,gender,birthday,address,qqnumber)\n"+
        //             "VALUES('朱燕男','男','2002-2-23','苏州',10001)";
        // 执行编译语句
        //     s.execute(sql);
        // }catch (SQLException e)
        // {
        //     e.printStackTrace();
        // }
        // StudentDAO studentDAO = new StudentDAOImpl();
        // studentDAO.delete(7);

        // Student s = new Student();
        // s.setName("lyh");
        // s.setAddress("njtech");
        // s.setGender("男");
        // s.setQqnumber(110);
        // s.setBirthday(new Date());
        StudentDAO studentDAO = new StudentDAOImpl();
        // studentDAO.insert(s);
        // studentDAO.insert(s);
        // System.out.println(s);


        // Student s = new Student();
        // s.setName("lxt");
        // s.setAddress("njtech");
        // s.setGender("女");
        // s.setQqnumber(119);
        // s.setId(1);
        // s.setBirthday(new Date());
        // studentDAO.update(s);


        // System.out.println(studentDAO.listByPage("李",0,3));
        // System.out.println(studentDAO.listByNameLike("李"));
        // studentDAO.testInsert();
        // GradeDAO gradeDAO = new GradeDAOImpl();
        // System.out.println(studentDAO.listAll());
        // System.out.println(gradeDAO.listBySid(2));
        // System.out.println(studentDAO.listAllWithGrade(0,3));
        // System.out.println(studentDAO.listByIdWithGrade(1));
        UserDao userDao = new UserDaoImpl();
        // System.out.println(userDao.listById(1));
        // User user = new User();
        // user.setId(6);
        // user.setPassword("6");
        // user.setUserName("nick6");
        // System.out.println(Service.register(user));
        // userDao.insert(user);

        mainView();




    }
}
