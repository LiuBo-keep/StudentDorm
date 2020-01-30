package com.hp.studentsushe.dao;

import com.hp.studentsushe.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@FunctionalInterface
@Mapper
public interface GenRenXinXiDao {

    public int xiu(Student student);
}
