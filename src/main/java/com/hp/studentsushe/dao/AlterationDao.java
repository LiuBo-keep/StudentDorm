package com.hp.studentsushe.dao;

import com.hp.studentsushe.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlterationDao {

    /**
     * 判断输入原始密码是否正确
     * @return String
     */
    public Student findPassword(String password);


    /**
     * 修改密码
     * @return int
     */
    public int updateAlteration(Student student);
}
