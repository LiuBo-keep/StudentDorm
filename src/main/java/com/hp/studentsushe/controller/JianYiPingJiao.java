package com.hp.studentsushe.controller;


import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class JianYiPingJiao {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/jianyi")
    public JsonResult add(
            @RequestParam("remake") String remake,
            HttpSession session
    ){
        /*Student student=(Student) session.getAttribute("Student");
        String sn=student.getSn();*/
        redisTemplate.opsForList().leftPush("1850510408",remake);
         return new JsonResult(1,"反馈成功");
    }
}
