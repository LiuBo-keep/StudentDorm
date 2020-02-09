package com.hp.studentsushe.controller;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.bean.WeiXiu;
import com.hp.studentsushe.service.WeiXiuService;
import com.hp.studentsushe.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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
        Student student=(Student) session.getAttribute("Student");
        WeiXiu weiXiu=new WeiXiu();
        weiXiu.setSn(student.getSn());
//        weiXiu.setSn("1850510408");
        weiXiu.setAddre(addre);
        weiXiu.setObj(obj);
        weiXiu.setPhone(phone);

        int count=weiXiuService.shang(weiXiu);

        if (count==0){
            return new JsonResult(0,"上报失败");
        }else {
            return new JsonResult(1,"上报成功");
        }
    }

    @GetMapping("/chaxun")
    private JsonResult get(
            HttpSession session
    ){
        Student student=(Student) session.getAttribute("Student");
        List<WeiXiu> list=weiXiuService.get(student.getSn());
        return new JsonResult(1,list);
    }
}
