package com.hp.studentsushe.controller;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.bean.WeiXiu;
import com.hp.studentsushe.service.WeiXiuService;
import com.hp.studentsushe.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/weixiu")
public class WeiXiuController {

    @Autowired
    private WeiXiuService weiXiuService;

    @PostMapping("/shangbao")
    public JsonResult shan(
            @RequestParam("addre") String addre,
            @RequestParam("obj") String obj,
            @RequestParam("phone") String phone,
            HttpSession session
    ){
//        Student student=(Student) session.getAttribute("Student");
        WeiXiu weiXiu=new WeiXiu();
//        weiXiu.setSn(student.getSn());
        weiXiu.setSn("1850510408");
        weiXiu.setAddre(addre);
        weiXiu.setObj(obj);
        weiXiu.setPhone(phone);

        weiXiuService.shang(weiXiu);

        return new JsonResult(1,"上报成功");
    }
}
