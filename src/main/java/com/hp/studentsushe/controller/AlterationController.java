package com.hp.studentsushe.controller;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.service.AlterationService;
import com.hp.studentsushe.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/Alter")
public class AlterationController {

    private final Logger log= LoggerFactory.getLogger(AlterationController.class);

    @Autowired
    private AlterationService alterationService;
    /**
     * 学生修改密码
     * @return
     */
    @PostMapping("/student")
    public JsonResult StudentAlter(
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword1") String newPassword1,
            @RequestParam("newPassword2") String newPassword2,
            HttpSession session
    ){
        if (oldPassword.trim()==""||oldPassword.trim()==null){
            return new JsonResult(0,"密码不能为空");
        }
        if (newPassword1.trim()==""||newPassword1.trim()==null){
            return new JsonResult(0,"密码不能为空");
        }
        if (newPassword2.trim()==""||newPassword2.trim()==null){
            return new JsonResult(0,"密码不能为空");
        }

        //查询密码是否存在
        boolean flag=alterationService.findPassword(oldPassword,session);
        if (!flag){
            return new JsonResult(0,"你的原始密码不正确");
        }

       //判断两次新密码输入是否一致
        if (!newPassword1.equals(newPassword2)){
            return new JsonResult(0,"两次输入新密码不一致");
        }

        Student  student=(Student) session.getAttribute("alteration");
        log.info("学生信息"+student);

        //修改密码
        int count=alterationService.updateAlteration(newPassword2,student.getUsername());
        log.info("影响行数"+count);
        if (count!=0){
            return new JsonResult(1,"密码修改成功");
        }else {
            return new JsonResult(0,"密码修改失败");
        }
    }
}
