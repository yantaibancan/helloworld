package com.iweb;

import com.iweb.DAO.StudentDAO;
import com.iweb.DAO.impl.StudentDAOImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author yiyu
 * @date 2023/11/15 20:40
 */
public class JDBCTest1 {
    private StudentDAO studentDAO;
    // 在其他测试方法运行之前 被该注解修饰的方法会自动执行
    @Before
    public void init()
    {
        studentDAO = new StudentDAOImpl();
    }
    @Test
    public void run()
    {
        // System.out.println(studentDAO.listAllWithGrade());
        Assert.assertEquals(9,studentDAO.listAll().size());
    }
    @Test
    public void run1()
    {
        System.out.println(studentDAO.listAll());
    }
    @Test
    public void testListAllWithGrade()
    {
        Assert.assertNull(studentDAO.listByNameLike("管"));
    }
    @After
    public void destroy()
    {
        System.out.println("你可以在这个方法中进行资源销毁或者是对象处理");
    }
}
