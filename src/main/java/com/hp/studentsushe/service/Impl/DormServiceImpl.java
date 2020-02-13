package com.hp.studentsushe.service.Impl;

import com.hp.studentsushe.bean.Dorm;
import com.hp.studentsushe.dao.DormDao;
import com.hp.studentsushe.service.DormService;
import com.hp.studentsushe.vo.DormInfo;
import com.hp.studentsushe.vo.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DormServiceImpl implements DormService {

    @Autowired
    private DormDao dormDao;

    @Override
    public PageObject<Dorm> findByData(DormInfo dormInfo) {
        PageObject<Dorm> pageObject=new PageObject<Dorm>();

        dormInfo.setSize(10);

        if (dormInfo.getPageCurrent()!=null){
            pageObject.setPageCurrent(dormInfo.getPageCurrent());
            /**页面有数据，重新计算开始行,每页显示5条数据*/
            dormInfo.setStartRow((dormInfo.getPageCurrent() - 1) * dormInfo.getSize());
        }

        /**总记录数*/
        pageObject.setTotal(dormDao.findConnt(dormInfo));
        System.out.println(pageObject.getTotal());

        /**总页数*/
        if (pageObject.getTotal() % dormInfo.getSize()!=0){
            pageObject.setPageCount((pageObject.getTotal() / dormInfo.getSize())+1);
        }else {
            pageObject.setPageCount((pageObject.getTotal() / dormInfo.getSize()));
        }

        /**结果集*/
        pageObject.setItems(dormDao.findByData(dormInfo));
        System.out.println(pageObject.getItems());


        return pageObject;
    }

    @Override
    public int add(Dorm dorm) {
        return dormDao.add(dorm);
    }

    @Override
    public Dorm findById(String id) {
        return dormDao.findById(id);
    }
}
