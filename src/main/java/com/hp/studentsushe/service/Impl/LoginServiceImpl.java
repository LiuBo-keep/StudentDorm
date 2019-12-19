package com.hp.studentsushe.service.Impl;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.bean.User;
import com.hp.studentsushe.dao.LoginDao;
import com.hp.studentsushe.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public User UserLogin(String username) {
        return loginDao.UserLogin(username);
    }

    @Override
    public Student StudentLogin(String username) {
        return loginDao.StudentLogin(username);
    }
}
