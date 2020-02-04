package com.hp.studentsushe.dao;

import com.hp.studentsushe.bean.WeiXiu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeiXiuDao {

    public int shang(WeiXiu weiXiu);
}
