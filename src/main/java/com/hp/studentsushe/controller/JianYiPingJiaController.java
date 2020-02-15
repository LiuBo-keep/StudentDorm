package com.hp.studentsushe.controller;


import com.hp.studentsushe.bean.YiJian;
import com.hp.studentsushe.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JianYiPingJiaController {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @PostMapping("/jianyi")
    public JsonResult add(
            YiJian yiJian
    ){
        System.out.println(yiJian);
        String key="联系方式:"+yiJian.getSelect2()+"联系内容:"+yiJian.getLianxi();
        redisTemplate.opsForValue().set(key,yiJian);
         return new JsonResult(1,"反馈成功");
    }
}
