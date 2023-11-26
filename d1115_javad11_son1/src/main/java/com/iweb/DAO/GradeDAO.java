package com.iweb.DAO;

import com.iweb.entity.Grade;

import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/15 18:26
 */
public interface GradeDAO {
    /**
     * 根据学生的sid获取他的成绩
     * @param sid 学生学号
     * @return
     */
    List<Grade> listBySid(Integer sid);
}
