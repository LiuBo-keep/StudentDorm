package com.hp.studentsushe.service;

import com.hp.studentsushe.bean.QueQin;
import com.hp.studentsushe.vo.Info;
import com.hp.studentsushe.vo.PageObject;

import java.util.List;

public interface QueQinService {

    /**
     * 缺勤记录
     * @return
     */
    public int addQueQin(QueQin queqin);

    /**
     * 查询我的考勤
     * @param list
     * @return
     */
    public PageObject<QueQin> findByData(Info info);
}
