package com.hp.studentsushe.service.Impl;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.bean.User;
import com.hp.studentsushe.dao.AlterationDao;
import com.hp.studentsushe.service.AlterationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlterationServiceImpl implements AlterationService {

    private final Logger log= LoggerFactory.getLogger(AlterationServiceImpl.class);

    @Autowired
    private AlterationDao alterationDao;

    @Override
    public Boolean findPassword(String password,HttpSession session) {
        Boolean flag=true;
        Student student=alterationDao.findPassword(password);
        if (student==null){
         flag=false;
        }else {
            session.setAttribute("alteration",student);
        }
        return flag;
    }

    @Override
    public int updateAlteration(String password,String name) {
        //学生入参信息
        log.info("新密码="+password+"学生姓名="+name);
        Student student=new Student();
        student.setUsername(name);
        student.setPassword(password);
        log.info(student.toString());
        return alterationDao.updateAlteration(student);

    }

    @Override
    public int updatePic(String picName,HttpSession session) {
        Integer role=(Integer)session.getAttribute("Type");
        log.info("角色是："+role);

        if (role==0){
            Student student=(Student) session.getAttribute("user");
            session.setAttribute("phone","photo/"+picName);
            log.info("学生信息："+student);
            student.setPhoto(picName);
            return alterationDao.StudentUpdatePhone(student);
        }else {
            User user=(User) session.getAttribute("user");
            session.setAttribute("phone","photo/"+picName);
            log.info("管理员信息："+user);
            user.setPhoto(picName);
            return alterationDao.AdminUpdatePhone(user);
        }
    }
}
