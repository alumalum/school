package com.mf.filter;

import com.mf.entity.Sort;
import com.mf.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;
@Component("sortFilter")
public class SortFilter implements Filter {

    @Autowired
    SortService sortService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("---SortFilter----doFilter------");
        List<Sort> sortList = sortService.getAllSort();
        request.setAttribute("sortList",sortList);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
