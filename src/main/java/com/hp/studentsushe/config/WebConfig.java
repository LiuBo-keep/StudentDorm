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
