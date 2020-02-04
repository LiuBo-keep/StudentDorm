package com.hp.studentsushe.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeiXiu implements Serializable {
    private Long id;
    private String sn; //学号
    private String addre; //保修地址
    private String obj; //维修对象
    private String phone; //联系电话
    private String status; //维修状态
    private Date time; //上报时间
    private String cost; //

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
