package com.hp.studentsushe.dao;

import com.hp.studentsushe.bean.Dorm;
import com.hp.studentsushe.vo.DormInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DormDao {

    public int findConnt(DormInfo dormInfo);

    public List<Dorm> findByData(DormInfo dormInfo);

    public int add(Dorm dorm);

    public Dorm findById(String id);
}
