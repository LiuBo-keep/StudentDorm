package com.hp.studentsushe.controller;

import com.hp.studentsushe.bean.QueQin;
import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.service.QueQinService;
import com.hp.studentsushe.utils.JsonResult;
import com.hp.studentsushe.vo.Info;
import com.hp.studentsushe.vo.PageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/kaoqin")
public class QueQinController {

    private final Logger log= LoggerFactory.getLogger(QueQinController.class);

    @Autowired
    private QueQinService queQinService;

    @PostMapping("/queqin")
    public JsonResult queqin(
            @RequestParam("xuehao") String xuehao,
            @RequestParam("date") Date date,
            @RequestParam("remake") String remake
    ){
        if (StringUtils.isEmpty(xuehao)){
            return new JsonResult(0,"缺勤学生，学号不能为空！");
        }
        if (StringUtils.isEmpty(date)){
            return new JsonResult(0,"缺勤日期不能为空！");
        }
        if (StringUtils.isEmpty(date)){
            return new JsonResult(0,"缺勤原因不能为空！");
        }

        log.info("缺勤信息为->"+"学号："+xuehao+"日期："+date+"备注："+remake);

        QueQin queQin=new QueQin();
        queQin.setSn(xuehao);
        queQin.setData(date);
        queQin.setRemake(remake);

        int count=queQinService.addQueQin(queQin);

        return new JsonResult(1,"保存成功");
    }

    /**
     *
     * @param info 接收页面信息
     * @return 返回结果
     */
    @PostMapping("/queqinjilu")
    public JsonResult jilu(Info info, HttpSession session){
        log.info("搜索开始时间："+info.getStart()+"搜索结束时间："+info.getStop());
        Student student=(Student) session.getAttribute("Student");
        info.setSn(student.getSn());
        PageObject<QueQin> pageObject=queQinService.findByData(info);
        return new JsonResult(1,pageObject);
    }
}
