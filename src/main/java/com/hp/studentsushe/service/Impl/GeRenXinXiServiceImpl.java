package com.hp.studentsushe.service.Impl;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.dao.GenRenXinXiDao;
import com.hp.studentsushe.service.GenRenXinXiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeRenXinXiServiceImpl implements GenRenXinXiService {

    @Autowired
    GenRenXinXiDao genRenXinXiDao;


    @Override
    public int xiu(Student student) {
        return genRenXinXiDao.xiu(student);
    }
}
