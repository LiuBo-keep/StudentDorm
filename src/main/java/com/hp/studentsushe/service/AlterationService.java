package com.hp.studentsushe.service;

import com.hp.studentsushe.bean.Student;

import javax.servlet.http.HttpSession;

public interface AlterationService {

    /**
     * 判断输入原始密码是否正确
     * @return String
     */
    public Boolean findPassword(String password,HttpSession session);

    /**
     * 修改密码
     * @return int
     */
    public int updateAlteration(String password,String name);
}
