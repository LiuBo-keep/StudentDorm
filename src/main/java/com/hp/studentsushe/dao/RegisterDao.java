package com.hp.studentsushe.dao;

import com.hp.studentsushe.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RegisterDao {

    /**
     * 管理员注册
     * @param user
     * @return
     */
    public int UserRegister(User user);
}
