package com.hp.studentsushe.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YiJian {
    //联系方式
    private String select2;
    //联系内容
    private String lianxi;
    //反馈信息
    private String message;
    //反馈学生姓名
    private String username;
}
