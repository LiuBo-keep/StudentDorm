package com.hp.studentsushe.controller;

import com.hp.studentsushe.bean.Student;
import com.hp.studentsushe.bean.User;
import com.hp.studentsushe.service.LoginService;
import com.hp.studentsushe.utils.CpachaUtil;
import com.hp.studentsushe.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/Login")
public class LoginController {

    private final Logger log= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    @PostMapping("/verify")
    public JsonResult Login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("vcode") String vcode,
            @RequestParam("type") int type,
            HttpServletRequest request
    ) {
        if (StringUtils.isEmpty(username)) {
            return new JsonResult(0, "用户名不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return new JsonResult(0, "密码不能为空");
        }
        if (StringUtils.isEmpty(vcode)) {
            return new JsonResult(0, "验证码不能为空");
        }

        String loginCpach = (String) request.getSession().getAttribute("loginCpach");
        if (StringUtils.isEmpty(loginCpach)) {
            return new JsonResult(0, "长时间未操作，验证码以失效，请刷新后重试");
        }
        if (!vcode.toUpperCase().equals(loginCpach.toUpperCase())) {
            return new JsonResult(0, "验证码错误");
        }

        request.getSession().setAttribute("loginCpach", null);
        //从数据库查询用户
        Student student=loginService.StudentLogin(username);
        log.info("学生数据:"+student);
        User user=loginService.UserLogin(username);
        log.info("管理员:"+user);
        /**
         * 身份验证，登录
         * 0：学生
         * 1：管理员
         */
        if (type==0){
            //学生
            if (student==null){
                return new JsonResult(0,"该用户不存在");
            }
            if (!password.equals(student.getPassword())){
                return new JsonResult(0,"密码错误");
            }
            //将学生信息存入session中,拦截验证
            request.getSession().setAttribute("user",student);
            //将学生信息存入session中,页面显示
            request.getSession().setAttribute("Student",student);
            //将学生头像路径存到session中，页面显示
            if (student.getPhoto()!=null){
                request.getSession().setAttribute("phone","photo/"+student.getPhoto());
            }else {
                request.getSession().setAttribute("phone","photo/timg.jfif");
            }
        }
        if (type==1){
            if (user==null){
                return new JsonResult(0,"该用户不存在");
            }
            if (!password.equals(user.getPassword())){
                return new JsonResult(0,"密码错误");
            }
            //将管理员信息存入session中,拦截验证
            request.getSession().setAttribute("user",user);
            //将管理员信息存入session中,页面显示
            request.getSession().setAttribute("Admin",user);
            //将管理员头像路径存到session中，页面显示
            if (user.getPhoto()!=null){
                request.getSession().setAttribute("phone","photo/"+user.getPhoto());
            }else {
                request.getSession().setAttribute("phone","photo/timg.jfif");
            }
        }
        //将身份信息存入session中
        request.getSession().setAttribute("Type",type);
        log.info("身份是："+type);

        return new JsonResult(1,"登录成功");
    }

    /**
     * 显示验证码
     *
     * @param request
     * @param vl
     * @param w
     * @param h
     * @param response
     */
    @GetMapping("/get_cpacha")
    public void getCpacha(HttpServletRequest request,
                          @RequestParam(value = "vl", defaultValue = "4", required = false) Integer vl,
                          @RequestParam(value = "w", defaultValue = "98", required = false) Integer w,
                          @RequestParam(value = "h", defaultValue = "33", required = false) Integer h,
                          HttpServletResponse response) {
        CpachaUtil cpachaUtil = new CpachaUtil(vl, w, h);
        //获取验证码
        String generatorVCode = cpachaUtil.generatorVCode();
        System.out.println("验证码是："+generatorVCode);
        //将验证码存入session
        request.getSession().setAttribute("loginCpach", generatorVCode);
        //给验证码加障碍
        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);

        try {
            ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
