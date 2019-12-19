package com.hp.studentsushe.service;

import com.hp.studentsushe.bean.User;

public interface RegisterService {

    /**
     * 管理员注册
     * @param user
     * @return
     */
    public int UserRegister(User user);
}
