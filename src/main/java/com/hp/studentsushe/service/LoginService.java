package com.hp.studentsushe.service;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.bean.User;

public interface LoginService {

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
