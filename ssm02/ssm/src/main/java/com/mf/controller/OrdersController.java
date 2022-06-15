package com.mf.controller;

import com.mf.Until.Pages;
import com.mf.dao.ProductMapper;
import com.mf.entity.Orders;
import com.mf.entity.OrdersDetail;
import com.mf.entity.Product;
import com.mf.entity.User;
import com.mf.service.OrdersDetailService;
import com.mf.service.OrdersService;
import com.mf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
    @Autowired
    ProductService productService;
    @Autowired
    ProductMapper productMapper;

    @RequestMapping("/getOrders")
    public String getOrders( Integer currentPage, HttpServletRequest request,Integer id){
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
        if(user.getRid() == 1){
            if(id == 1){
                return "orderAllList";
            }else {
                return "returnOrderList";
            }
        }else {
            return "orderUser";
        }
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

    @RequestMapping("/updateOrdersState")
    @Transactional
    public String updateOrdersState(Integer oid,Integer id){
        List<OrdersDetail> ordersDetailList = ordersDetailService.getAllOrdersDetailByOid(oid);
        if(id == 1){
            for (OrdersDetail o:ordersDetailList){
                Product product = productService.getProductById(o.getPid());
                productMapper.updateProductStock(product.getPid(),(product.getStock() - o.getQuantity()));
            }
            ordersService.updateOrdersState(oid,"已发货");
        }else if(id == 2) {
            ordersService.updateOrdersState(oid,"退货");
        }else if(id == 3){
            for (OrdersDetail o:ordersDetailList){
                Product product = productService.getProductById(o.getPid());
                productMapper.updateProductStock(product.getPid(),(product.getStock() + o.getQuantity()));
            }
            ordersService.updateOrdersState(oid,"已同意退货");
        }
        if(id ==3){
            return "redirect:/orders/getOrders?id=3";
        }else {
            return "redirect:/orders/getOrders?id=1";
        }

    }
}
