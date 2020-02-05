package com.hp.studentsushe.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
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
    private String remark;//备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }

    public String getSushe() {
        return sushe;
    }

    public void setSushe(String sushe) {
        this.sushe = sushe;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", clazzId=" + clazzId +
                ", sushe='" + sushe + '\'' +
                ", bed='" + bed + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", photo='" + photo + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
