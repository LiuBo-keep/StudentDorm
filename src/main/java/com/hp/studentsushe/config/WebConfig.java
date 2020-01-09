package com.hp.studentsushe.config;

import com.hp.studentsushe.utils.LoginInterceotorsUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    //访问/login跳转到登录页面
        registry.addViewController("/dorm").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/geRenXinxiGuanLi").setViewName("geRenXinxiGuanLi");
        registry.addViewController("/ruZhuXinXiDengJi").setViewName("ruZhuXinXiDengJi");
        registry.addViewController("/queQinJiLu").setViewName("queQinJiLu");
        registry.addViewController("/weiXiuXinXi").setViewName("/weiXiuXinXi");
        registry.addViewController("/weiXiuJiLu").setViewName("weiXiuJiLu");
        registry.addViewController("/jianYiPingJia").setViewName("jianYiPingJia");
        registry.addViewController("/xueShengGuanLi").setViewName("xueShengGuanLi");
        registry.addViewController("/suSheGuanLi").setViewName("suSheGuanLi");
        registry.addViewController("/XueShengRuzhuDengJi").setViewName("XueShengRuzhuDengJi");
        registry.addViewController("/xueShengQinShiTiaoHuan").setViewName("xueShengQinShiTiaoHuan");
        registry.addViewController("/xueShengQianChu").setViewName("xueShengQianChu");
        registry.addViewController("/qianChuJiLu").setViewName("qianChuJiLu");
        registry.addViewController("/louYuGuanLi").setViewName("louYuGuanLi");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceotorsUtil())
//               //拦截所有请求
////                .addPathPatterns("/**")
//                //对/dorm请求放行
//                .excludePathPatterns("/dorm","/get_cpacha");
//    }
}
