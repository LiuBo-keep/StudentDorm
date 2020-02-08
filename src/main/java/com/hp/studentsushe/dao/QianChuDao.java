package com.hp.studentsushe.dao;


import com.hp.studentsushe.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QianChuDao {

    public Student findBysn(String xuehao);

    public int upstudent(Student student);

    public int upsushe(Student student);
}
