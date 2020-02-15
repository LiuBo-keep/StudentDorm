package com.hp.studentsushe.controller;


import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ruzhu")
public class RuzhuController {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @PostMapping("/shangbao")
    public JsonResult add(
            @RequestParam("sn") String sn,
            @RequestParam("clazzId") String clazzId,
            @RequestParam("sex") String sex
    ){
        System.out.println("--------------------------------");
        redisTemplate.opsForList().leftPush(sn,sn);
        redisTemplate.opsForList().leftPush(sn,clazzId);
        redisTemplate.opsForList().leftPush(sn,sex);
        return new JsonResult(1,"保存成功！");
    }
}
