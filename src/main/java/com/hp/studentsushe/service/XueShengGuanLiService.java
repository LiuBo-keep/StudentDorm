package com.hp.studentsushe.service;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.vo.PageObject;
import com.hp.studentsushe.vo.StudentInfo;

import java.util.List;

public interface XueShengGuanLiService {


    /**
     * 获取所以学生信息
     * @return
     */
    public PageObject<Student> getAll(StudentInfo studentInfo);
}
