package com.hp.studentsushe.controller;

import com.hp.studentsushe.service.DormService;
import com.hp.studentsushe.utils.JsonResult;
import com.hp.studentsushe.vo.DormInfo;
import com.hp.studentsushe.vo.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrator")
public class DormController {

    @Autowired
    private DormService dormService;

    @GetMapping("/dorm")
    public JsonResult getAll(DormInfo dormInfo){
        PageObject pageObject=dormService.findByData(dormInfo);

        return new JsonResult(1,pageObject);
    }
}
