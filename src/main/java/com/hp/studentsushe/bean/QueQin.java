package com.hp.studentsushe.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueQin implements Serializable {
    private String id;
    private String data;
    private String sn;
    private String username;
    private String sushe;
    private String remake;
}
