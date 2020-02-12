package com.hp.studentsushe.controller;


import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.service.XueShengGuanLiService;
import com.hp.studentsushe.utils.JsonResult;
import com.hp.studentsushe.vo.PageObject;
import com.hp.studentsushe.vo.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrator")
public class XueShengGuanLiController {

    @Autowired
    private XueShengGuanLiService xueShengGuanLiService;

    @GetMapping("/xueShengGuanLi")
    public JsonResult getAll(
            StudentInfo studentInfo,
            @RequestParam(value = "qita",required = false) String qita,
            @RequestParam(value = "qitanei" ,required = false) String qitanei
            ){
        if ("姓名".equals(qita)){
            studentInfo.setUsername(qitanei);
        }
        if ("学号".equals(qita)){
            studentInfo.setSn(qitanei);
        }
        if ("班级".equals(qita)){
            studentInfo.setClazz(qitanei);
        }
        PageObject<Student> pageObject=xueShengGuanLiService.getAll(studentInfo);
        return new JsonResult(1,pageObject);
    }
}
