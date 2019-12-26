package com.hp.studentsushe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AlterationController {

    /**
     * 学生修改密码
     * @return
     */
    @PostMapping("/student")
    public Map<String,Object> StudentAlter(
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword1") String newPassword1,
            @RequestParam("newPassword2") String newPassword2
    ){
        Map<String,Object> map=new HashMap<String,Object>();
        System.out.println(oldPassword+"--"+newPassword1);
        return map;
    }
}
