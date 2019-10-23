package org.seckill.interceptor;

import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seckill.dao.UserDao;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();
		//判断url是否是公开地址（实际使用时将公开地址配置配置文件中）
		//这里公开地址是登陆提交的地址
		if(url.indexOf("login_check")>0){
			return true;
		}
		
        //int result = 0;
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
        	for(Cookie c : cookies) {
	        	if(c.getName().equals("UserId")) {
	        		System.out.println(c.getValue()+"------------------------"+URLDecoder.decode(c.getValue(),"utf-8"));
	        		return true;
	        	}
        	}
        }
        
        System.out.println("尚未登录，调到登录页面");
        response.sendRedirect("/seckill/login");
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("afterCompletion");
    }

}
