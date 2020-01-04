package com.hp.studentsushe.dao;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.bean.User;
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

    /**
     * 学生修改头像
     * @param student
     * @return
     */
    public int StudentUpdatePhone(Student student);

    /**
     * 管理员修改头像
     * @param user
     * @return
     */
    public int AdminUpdatePhone(User user);
}
