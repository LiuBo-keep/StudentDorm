package com.hp.studentsushe.dao;

import com.hp.studentsushe.bean.WeiXiu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WeiXiuDao {

    public int shang(WeiXiu weiXiu);

    public List<WeiXiu> get(String sn);
}
