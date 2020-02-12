package com.hp.studentsushe.service;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.vo.Info;
import com.hp.studentsushe.vo.PageObject;
import com.hp.studentsushe.vo.StudentInfo;

public interface QianChuService {
    public Student findBysn(String xuehao);

    public int updata(Student student);

    public int upsushe(Student student);

    public PageObject<Student> findByStatus(StudentInfo studentInfo);
}
