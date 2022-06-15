package com.mf.interceptor;

import com.mf.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("--------preHandle----------");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        System.out.println("user:"+user);
        if(user != null){
            return true;
        }else {
            response.sendRedirect("/login.jsp");
            return false;
        }
    }
}
