package com.hp.studentsushe.service.Impl;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.dao.QianChuDao;
import com.hp.studentsushe.service.QianChuService;
import com.hp.studentsushe.vo.Info;
import com.hp.studentsushe.vo.PageObject;
import com.hp.studentsushe.vo.StudentInfo;
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

    @Override
    public int upsushe(Student student) {
        return qianChuDao.upsushe(student);
    }

    @Override
    public PageObject<Student> findByStatus(StudentInfo studentInfo) {
        PageObject<Student> pageObject=new PageObject<Student>();

        /**设置每页显示条数*/
        studentInfo.setSize(10);

        if (studentInfo.getPageCurrent()!=null){
            pageObject.setPageCurrent(studentInfo.getPageCurrent());
            /**页面有数据，重新计算开始行,每页显示5条数据*/
            studentInfo.setStartRow((studentInfo.getPageCurrent() - 1) * studentInfo.getSize());
        }

        /**总记录数*/
        pageObject.setTotal(qianChuDao.findConnt(studentInfo));
        System.out.println(pageObject.getTotal());

        /**总页数*/
        if (pageObject.getTotal() % studentInfo.getSize()!=0){
            pageObject.setPageCount((pageObject.getTotal() / studentInfo.getSize())+1);
        }else {
            pageObject.setPageCount((pageObject.getTotal() / studentInfo.getSize()));
        }

        /**结果集*/
        pageObject.setItems(qianChuDao.findByData(studentInfo));
        System.out.println(pageObject.getItems());

        return pageObject;
    }
}
