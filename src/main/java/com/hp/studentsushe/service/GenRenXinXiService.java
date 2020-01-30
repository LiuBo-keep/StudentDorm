package com.hp.studentsushe.service;

import com.hp.studentsushe.bean.Student;

@FunctionalInterface
public interface GenRenXinXiService {

    /**
     * 修改个人信息
     * @return
     */
    public int xiu(Student student);
}
