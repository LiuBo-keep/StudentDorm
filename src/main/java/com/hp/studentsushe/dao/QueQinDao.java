package com.hp.studentsushe.dao;

import com.hp.studentsushe.bean.QueQin;
import com.hp.studentsushe.vo.Info;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QueQinDao {

    public int addQueQin(QueQin queqin);

    public int findConnt(Info info);

    public List<QueQin> findByData(Info info);
}
