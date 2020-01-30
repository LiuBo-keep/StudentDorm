package com.hp.studentsushe.service.Impl;

import com.hp.studentsushe.bean.QueQin;
import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.dao.LoginDao;
import com.hp.studentsushe.dao.QueQinDao;
import com.hp.studentsushe.service.QueQinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueQinServiceImpl implements QueQinService {

    private final Logger log= LoggerFactory.getLogger(QueQinServiceImpl.class);

    @Autowired
    private QueQinDao queQinDao;
    @Autowired
    private LoginDao loginDao;

    @Override
    public int addQueQin(QueQin queqin) {
        Student student=loginDao.StudentLogin(queqin.getSn());
        log.info("缺勤学生信息："+student.toString());
        queqin.setUsername(student.getUsername());
        queqin.setSushe(student.getSushe());
        return queQinDao.addQueQin(queqin);
    }
}
