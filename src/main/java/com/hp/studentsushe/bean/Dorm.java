package com.hp.studentsushe.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dorm {
    private Long id;
    //寝室号
    private String dormId;
    //寝室类型
    private String dormType;
    //寝室长
    private String dormMonitor;
    //寝室长电话
    private String dormMonitorPhone;
}
