package com.hp.studentsushe.controller;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.service.QianChuService;
import com.hp.studentsushe.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 学生迁出记录
 */
@RestController
@RequestMapping("/emigration")
public class QianChuController {

    @Autowired
    private QianChuService qianChuService;

    @GetMapping("/me")
    public JsonResult get(
            @RequestParam("xuehao") String xuehao,
            HttpSession session
    ){
        Student student=qianChuService.findBysn(xuehao);
        session.setAttribute("emigration",student);
        return new JsonResult(1,"返回");
    }

    @PostMapping("/tu")
    public JsonResult upStudent(
            @RequestParam("qianremark") String qianremark,
            HttpSession session
    ){
        Student student1=(Student) session.getAttribute("emigration");
        Student student=new Student();
        student.setSn(student1.getSn());
        student.setStatus("迁出");
        student.setQianRemark(qianremark);
        qianChuService.updata(student);
        return new JsonResult(1,"迁出成功");
    }
}
