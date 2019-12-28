package com.hp.studentsushe.controller;

import com.hp.studentsushe.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/alter")
public class AlterationController {

    private final Logger log= LoggerFactory.getLogger(AlterationController.class);
    /**
     * 学生修改密码
     * @return
     */
    @PostMapping("/student")
    public JsonResult StudentAlter(
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword1") String newPassword1,
            @RequestParam("newPassword2") String newPassword2
    ){
        return new JsonResult(0,"aaaaa");
    }
}
