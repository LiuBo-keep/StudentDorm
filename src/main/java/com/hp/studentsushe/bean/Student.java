package com.hp.studentsushe.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student implements Serializable {
    private Long id;
    private String sn;//学号
    private String username;
    private String password;
    private String clazzId;//班级id
    private String sushe;//宿舍号
    private String bed;//床号
    private String sex;
    private String photo;//头像
    private String status;//住宿状态
    private String remark;//个性签名
    private Date qianchuDate;//迁出日期
    private String qianRemark;//迁出备注
}
