package com.hp.studentsushe.service.Impl;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.dao.XueShengGuanLiDao;
import com.hp.studentsushe.service.XueShengGuanLiService;
import com.hp.studentsushe.vo.PageObject;
import com.hp.studentsushe.vo.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XueShengGuanLiServiceImpl implements XueShengGuanLiService {

    @Autowired
    private XueShengGuanLiDao xueShengGuanLiDao;

    @Override
    public PageObject<Student> getAll(StudentInfo studentInfo) {
        PageObject<Student> pageObject=new PageObject<Student>();

        /**设置每页显示条数*/
        studentInfo.setSize(3);

        if (studentInfo.getPageCurrent()!=null){
            pageObject.setPageCurrent(studentInfo.getPageCurrent());
            /**页面有数据，重新计算开始行,每页显示5条数据*/
            studentInfo.setStartRow((studentInfo.getPageCurrent() - 1) * studentInfo.getSize());
        }

        /**总记录数*/
        pageObject.setTotal(xueShengGuanLiDao.findConnt(studentInfo));
        System.out.println(pageObject.getTotal());

        /**总页数*/
        if (pageObject.getTotal() % studentInfo.getSize()!=0){
            pageObject.setPageCount((pageObject.getTotal() / studentInfo.getSize())+1);
        }else {
            pageObject.setPageCount((pageObject.getTotal() / studentInfo.getSize()));
        }

        /**结果集*/
        pageObject.setItems(xueShengGuanLiDao.findByData(studentInfo));
        System.out.println(pageObject.getItems());

        return pageObject;
    }
}
