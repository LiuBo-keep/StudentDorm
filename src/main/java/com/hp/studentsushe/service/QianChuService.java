package com.hp.studentsushe.service;

import com.hp.studentsushe.bean.Student;

public interface QianChuService {
    public Student findBysn(String xuehao);

    public int updata(Student student);
}
