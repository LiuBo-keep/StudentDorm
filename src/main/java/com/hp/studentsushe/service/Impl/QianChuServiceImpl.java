package com.hp.studentsushe.service.Impl;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.dao.QianChuDao;
import com.hp.studentsushe.service.QianChuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QianChuServiceImpl implements QianChuService {

    @Autowired
    private QianChuDao qianChuDao;

    @Override
    public Student findBysn(String xuehao) {

        return qianChuDao.findBysn(xuehao);
    }

    @Override
    public int updata(Student student) {
        return qianChuDao.upstudent(student);
    }
}
