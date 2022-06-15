package com.mf.filter;

import com.mf.entity.Roles;
import com.mf.entity.User;
import com.mf.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Component("loginFilter")
public class LoginFilter implements Filter {

    @Autowired
    RolesService rolesService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("-------doFilter------");
        List<Roles> rolesList = rolesService.getRoles();
        request.setAttribute("rolesList",rolesList);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
