package com.hp.studentsushe.controller;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.bean.User;
import com.hp.studentsushe.service.RegisterService;
import com.hp.studentsushe.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    /**
     * 管理员注册
     * 姓名
     * 密码
     * @param user
     * @return
     */
    @PostMapping("/user")
    public JsonResult UserRegister(User user){
        int count=registerService.UserRegister(user);
        if (count>0){
            return new JsonResult(1,"注册成功");
        }else {
            return new JsonResult(0,"注册失败");
        }
    }
}
