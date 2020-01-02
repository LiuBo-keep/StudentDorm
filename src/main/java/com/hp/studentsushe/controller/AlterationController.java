package com.hp.studentsushe.controller;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.service.AlterationService;
import com.hp.studentsushe.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@RestController
@RequestMapping("/Alter")
public class AlterationController {

    private final Logger log= LoggerFactory.getLogger(AlterationController.class);

    @Autowired
    private AlterationService alterationService;
    /**
     * 学生修改密码
     * @return
     */
    @PostMapping("/student")
    public JsonResult StudentAlter(
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword1") String newPassword1,
            @RequestParam("newPassword2") String newPassword2,
            HttpSession session
    ){
        if (oldPassword.trim()==""||oldPassword.trim()==null){
            return new JsonResult(0,"密码不能为空");
        }
        if (newPassword1.trim()==""||newPassword1.trim()==null){
            return new JsonResult(0,"密码不能为空");
        }
        if (newPassword2.trim()==""||newPassword2.trim()==null){
            return new JsonResult(0,"密码不能为空");
        }

        //查询密码是否存在
        boolean flag=alterationService.findPassword(oldPassword,session);
        if (!flag){
            return new JsonResult(0,"你的原始密码不正确");
        }

       //判断两次新密码输入是否一致
        if (!newPassword1.equals(newPassword2)){
            return new JsonResult(0,"两次输入新密码不一致");
        }

        Student  student=(Student) session.getAttribute("alteration");
        log.info("学生信息"+student);

        //修改密码
        int count=alterationService.updateAlteration(newPassword2,student.getUsername());
        log.info("影响行数"+count);
        if (count!=0){
            return new JsonResult(1,"密码修改成功");
        }else {
            return new JsonResult(0,"密码修改失败");
        }
    }

    /**
     * 修改头像
     * @return JsonResult
     */
    @PostMapping("/pic")
    public JsonResult updatePic(MultipartFile photo,
                                HttpSession session
    ) throws IOException {
       if (photo!=null){
           if (photo.getSize()<10485760){
               //获取文件扩展名
               String suffix=photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".")+1,photo.getOriginalFilename().length());
               if ("jpg,png,gif,jpeg".contains(suffix.toLowerCase())){
                   //用uuid给图片重新命名
                   String uuid=UUID.randomUUID().toString().toLowerCase().replace("-","");
                   String newName=uuid.concat("."+suffix);

                   //将文件保存在本地磁盘
                   File file=new File("M:\\photo\\"+newName);
                   if (!file.exists()){
                       file.mkdirs();//判断文件加是否存，不存在就创建
                   }

                   photo.transferTo(file);

                   Student student=(Student) session.getAttribute("alteration");
                   log.info(student.toString());
                   return new JsonResult(1,"上传成功");
               }else {
                   return new JsonResult(0,"您上传的文件格式不对，请上传jpg,png,gif,jpeg格式的图片");
               }
           }else {
               return new JsonResult(0,"文件大小超过14M，请上传小于10M的图片");
           }
       }else {
           return new JsonResult(0,"请选择文件");
       }
    }
}
