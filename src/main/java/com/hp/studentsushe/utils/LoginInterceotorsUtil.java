package com.hp.studentsushe.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceotorsUtil implements HandlerInterceptor {

    private final Logger log= LoggerFactory.getLogger(LoginInterceotorsUtil.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        String url=request.getRequestURI();
        log.info("进入拦截器--"+"请求url:"+url);
        Object  user=request.getSession().getAttribute("user");

        if (user==null){
            log.info("未登录或登录以时效，url="+url);
           /* if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
                //ajax请求
                HashMap<String,String> hashMap=new HashMap<String,String>();
                hashMap.put("type","error");
                hashMap.put("msg","登录状态已失效，请重新去登录");
                response.getWriter().write(JSONObject.fromObject(hashMap).toString());
                return false;
            }
*/
            return false;
        }
        log.info("通过拦截器");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
