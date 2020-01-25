package com.hp.studentsushe.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class QueQin implements Serializable {
    private String id;
    private String data;
    private String sn;
    private String username;
    private String sushe;
    private String remake;
}
