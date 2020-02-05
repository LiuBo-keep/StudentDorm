package com.hp.studentsushe.controller;


import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.service.XueShengGuanLiService;
import com.hp.studentsushe.utils.JsonResult;
import com.hp.studentsushe.vo.PageObject;
import com.hp.studentsushe.vo.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrator")
public class XueShengGuanLiController {

    @Autowired
    private XueShengGuanLiService xueShengGuanLiService;

    @GetMapping("/xueShengGuanLi")
    public JsonResult getAll(StudentInfo studentInfo){
        PageObject<Student> pageObject=xueShengGuanLiService.getAll(studentInfo);
        return new JsonResult(1,pageObject);
    }
}
