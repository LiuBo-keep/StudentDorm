package com.hp.studentsushe.service;

import com.hp.studentsushe.bean.Dorm;
import com.hp.studentsushe.vo.DormInfo;
import com.hp.studentsushe.vo.PageObject;

public interface DormService {
    public PageObject<Dorm> findByData(DormInfo dormInfo);

    public int add(Dorm dorm);

    public Dorm findById(String id);
}
