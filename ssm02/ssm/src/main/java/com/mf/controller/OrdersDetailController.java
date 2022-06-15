package com.mf.controller;

import com.mf.entity.OrdersDetail;
import com.mf.entity.User;
import com.mf.service.OrdersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/ordersDetail")
public class OrdersDetailController {
    @Autowired
    OrdersDetailService ordersDetailService;
    @RequestMapping("/getDetail")
    public String getDetail(Integer id, HttpServletRequest request){
        System.out.println("------getDetail----------");
        System.out.println("id"+id);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<OrdersDetail> ordersDetailList = ordersDetailService.getAllOrdersDetailByOid(id);
        for(OrdersDetail o:ordersDetailList){
            System.out.println(o);
        }
        request.setAttribute("ordersDetailList",ordersDetailList);
        if(user.getRid() == 1){
            return "orderDetailAdmin";
        }
        return "orderDetailList";
    }
}
