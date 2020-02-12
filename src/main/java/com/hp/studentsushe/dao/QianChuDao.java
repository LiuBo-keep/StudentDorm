package com.hp.studentsushe.dao;


import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.vo.Info;
import com.hp.studentsushe.vo.StudentInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QianChuDao {

    public Student findBysn(String xuehao);

    public int upstudent(Student student);

    public int upsushe(Student student);

    public int findConnt(StudentInfo studentInfo);

    public List<Student> findByData(StudentInfo studentInfo);
}
