package com.hp.studentsushe.service.Impl;

import com.hp.studentsushe.bean.QueQin;
import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.dao.LoginDao;
import com.hp.studentsushe.dao.QueQinDao;
import com.hp.studentsushe.service.QueQinService;
import com.hp.studentsushe.vo.Info;
import com.hp.studentsushe.vo.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageObject<QueQin> findByData(Info info) {
        PageObject<QueQin> pageObject=new PageObject<QueQin>();

        /**设置每页显示条数*/
        info.setSize(10);

        if (info.getPageCurrent()!=null){
            pageObject.setPageCurrent(info.getPageCurrent());
            /**页面有数据，重新计算开始行,每页显示5条数据*/
            info.setStartRow((info.getPageCurrent() - 1) * info.getSize());
        }

        /**总记录数*/
        pageObject.setTotal(queQinDao.findConnt(info));
        System.out.println(pageObject.getTotal());

        /**总页数*/
        if (pageObject.getTotal() % info.getSize()!=0){
            pageObject.setPageCount((pageObject.getTotal() / info.getSize())+1);
        }else {
            pageObject.setPageCount((pageObject.getTotal() / info.getSize()));
        }

        /**结果集*/
        pageObject.setItems(queQinDao.findByData(info));
        System.out.println(pageObject.getItems());

        return pageObject;
    }
}
