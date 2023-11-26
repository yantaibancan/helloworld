package com.iweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/14 19:45
 */
@Data
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private String address;
    private Long qqnumber;
    private List<Grade> grades;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", qqnumber=" + qqnumber +
                ", grades=" + grades +
                '}'+"\r\n";
    }
}
