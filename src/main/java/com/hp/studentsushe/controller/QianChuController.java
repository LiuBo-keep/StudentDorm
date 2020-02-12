package com.hp.studentsushe.controller;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.service.QianChuService;
import com.hp.studentsushe.utils.JsonResult;
import com.hp.studentsushe.vo.PageObject;
import com.hp.studentsushe.vo.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 学生迁出记录
 */
@RestController
@RequestMapping("/emigration")
public class QianChuController {

    @Autowired
    private QianChuService qianChuService;

    //根据学号查询学生信息
    @GetMapping("/me")
    public JsonResult get(
            @RequestParam("xuehao") String xuehao,
            HttpSession session
    ){
        Student student=qianChuService.findBysn(xuehao);
        session.setAttribute("emigration",student.getSn());
        return new JsonResult(1,"学生信息",student);
    }

    //学生迁出
    @PostMapping("/tu")
    public JsonResult upStudent(
            @RequestParam("qianremark") String qianremark,
            HttpSession session
    ){
        Student student=new Student();
        student.setSn((String) session.getAttribute("emigration"));
        student.setStatus("迁出");
        student.setQianchuDate(new Date());
        student.setQianRemark(qianremark);
        qianChuService.updata(student);
        return new JsonResult(1,"迁出成功");
    }

    //查询所以迁出学生
    @GetMapping("/AllQianChu")
    public JsonResult getAll(StudentInfo studentInfo){
        studentInfo.setStatus("迁出");
        PageObject<Student> pageObject=qianChuService.findByStatus(studentInfo);
        return new JsonResult(1,pageObject);
    }

    //学生调换宿舍
    @PostMapping("/tiao")
    public JsonResult upSuShe(
            @RequestParam("newsushe") String newsushe,
            @RequestParam("newbed") String newbed,
            HttpSession session
    ){

        System.out.println("新宿舍："+newsushe+"新床位："+newbed);
        Student student=new Student();
        student.setSn((String) session.getAttribute("emigration"));
        student.setSushe(newsushe);
        student.setBed(newbed);

        qianChuService.upsushe(student);
        return new JsonResult(1,"调换成功！");
    }
}
