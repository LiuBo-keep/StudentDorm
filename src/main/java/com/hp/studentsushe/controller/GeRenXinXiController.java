package com.hp.studentsushe.controller;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.service.GenRenXinXiService;
import com.hp.studentsushe.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/genren")
public class GeRenXinXiController {

    private final Logger log= LoggerFactory.getLogger(GeRenXinXiController.class);

    @Autowired
    GenRenXinXiService genRenXinXiService;

    @PostMapping("/xiugai")
    public JsonResult xiu(
            @RequestParam("xuehao") String sn,
            @RequestParam("xingming") String username,
            @RequestParam("xingbie") String sex,
            @RequestParam("nianji") Long clazzId,
            @RequestParam("sushe") String sushe,
            @RequestParam("chuanghao") String bed,
            @RequestParam("rema") String remark,
            HttpSession session
    ){
        log.info("入参信息->"+"学号:"+sn+"姓名:"+username+"性别:"+sex+"年级:"+clazzId+"宿舍:"+sushe+"床号:"+bed+"备注:"+remark);
        if (StringUtils.isEmpty(sn)){
            return new JsonResult(0,"学号不能为空！");
        }
        if (StringUtils.isEmpty(username)){
            return new JsonResult(0,"姓名不能为空！");
        }
        if (StringUtils.isEmpty(clazzId)){
            return new JsonResult(0,"年级不能为空！");
        }
        if (StringUtils.isEmpty(sushe)){
            return new JsonResult(0,"宿舍号不能为空！");
        }
        if (StringUtils.isEmpty(bed)){
            return new JsonResult(0,"床号不能为空！");
        }

        //修改信息
        Student student=new Student();
        student.setSn(sn);
        student.setUsername(username);
        student.setClazzId(clazzId);
        student.setSushe(sushe);
        student.setSex(sex);
        student.setBed(bed);
        student.setRemark(remark);

        genRenXinXiService.xiu(student);

        session.setAttribute("Student",student);

        return new JsonResult(1,"修改成功！");
    }
}
