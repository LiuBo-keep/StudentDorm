package com.hp.studentsushe.dao;

import com.hp.studentsushe.bean.QueQin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueQinDao {

    public int addQueQin(QueQin queqin);
}
