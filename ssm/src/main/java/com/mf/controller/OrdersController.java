package com.mf.controller;

import com.mf.Until.Pages;
import com.mf.entity.Orders;
import com.mf.entity.OrdersDetail;
import com.mf.entity.User;
import com.mf.service.OrdersDetailService;
import com.mf.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    @Autowired
    OrdersDetailService ordersDetailService;

    @RequestMapping("/getOrders")
    public String getOrders( Integer currentPage, HttpServletRequest request){
        System.out.println("-------getOrders-------");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (currentPage == null) {
            currentPage = 1;
        }
        Pages pages = new Pages();
        pages.setCurrentPage(currentPage);
        List<Orders> ordersList = null;
        if(user.getRid() == 1){
            pages.setTotalCount(ordersService.getOrdersCount(null));
            ordersList = ordersService.getOrders(null,currentPage,pages.getPageSize());
        }else {
            pages.setTotalCount(ordersService.getOrdersCount(user.getUid()));
            ordersList = ordersService.getOrders(user.getUid(),currentPage,pages.getPageSize());
        }
        for (Orders o:ordersList){
            System.out.println(o);
        }
        request.setAttribute("ordersList",ordersList);
        request.setAttribute("pages",pages);
        return "orderAllList";
    }

    @RequestMapping("/addOrders")
    public String addOrders(HttpServletRequest request) {
        System.out.println("-------addOrders-------");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Orders orders = ordersService.addOrders(user.getUid());
        request.setAttribute("orders", orders);
        System.out.println("orders"+orders);
        List<OrdersDetail> ordersDetailList = ordersDetailService.getAllOrdersDetailByOid(orders.getOid());
        request.setAttribute("ordersDetailList",ordersDetailList);
        return "orderList";
    }
}
