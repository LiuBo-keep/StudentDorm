package com.hp.studentsushe.controller;

import com.hp.studentsushe.bean.Dorm;
import com.hp.studentsushe.service.DormService;
import com.hp.studentsushe.utils.JsonResult;
import com.hp.studentsushe.vo.DormInfo;
import com.hp.studentsushe.vo.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrator")
public class DormController {

    @Autowired
    private DormService dormService;

    //查询所以宿舍
    @GetMapping("/dorm")
    public JsonResult getAll(
            DormInfo dormInfo,
            @RequestParam("dorm") String dorm,
            @RequestParam("dorms") String dorms
    ){
        if ("寝室".equals(dorm)){
            dormInfo.setDormId(dorms);
        }
        if ("舍长".equals(dorm)){
            dormInfo.setDormMonitor(dorms);
        }

        PageObject pageObject=dormService.findByData(dormInfo);

        return new JsonResult(1,pageObject);
    }

    //添加宿舍
    @PostMapping("/addDorm")
    public JsonResult add(Dorm dorm){
        Dorm dorm1=dormService.findById(dorm.getDormId());
        if (dorm1!=null){
         return new JsonResult(0,"该宿舍以存在，请重新添加！");
        }
        dormService.add(dorm);
        return new JsonResult(1,"添加成功！");
    }
}
