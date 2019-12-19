package com.hp.studentsushe.dao;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDao {

    /**
     * 管理员登录
     * @param username
     * @return
     */
    public User UserLogin(String username);

    /**
     * 学生登录
     * @param username
     * @return
     */
    public Student StudentLogin(String username);
}
