package com.hp.studentsushe.service.Impl;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.bean.User;
import com.hp.studentsushe.dao.RegisterDao;
import com.hp.studentsushe.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;

    @Override
    public int UserRegister(User user) {
        return registerDao.UserRegister(user);
    }
}
