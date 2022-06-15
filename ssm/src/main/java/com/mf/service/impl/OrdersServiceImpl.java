package com.mf.service.impl;

import com.mf.dao.CartMapper;
import com.mf.dao.OrdersDetailMapper;
import com.mf.dao.OrdersMapper;
import com.mf.entity.Cart;
import com.mf.entity.Orders;
import com.mf.entity.OrdersDetail;
import com.mf.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    OrdersDetailMapper ordersDetailMapper;
    @Autowired
    CartMapper cartMapper;

    @Override
    public Orders addOrders(Integer uid) {
        List<Cart> cartList = cartMapper.getCartByUid(uid, 1, 0);
        double totalMoney = 0;
        for (Cart c : cartList) {
            totalMoney += (c.getProduct().getPrice() * c.getQuantity());
        }
        Orders orders = new Orders();
        orders.setUid(uid);
        orders.setTotalMoney(totalMoney);
        orders.setCreateTime(new Date());
        ordersMapper.addOrders(orders);
        for (Cart c : cartList) {
            OrdersDetail ordersDetail = new OrdersDetail();
            ordersDetail.setOid(orders.getOid());
            ordersDetail.setPname(c.getProduct().getPname());
            ordersDetail.setPrice(c.getProduct().getPrice());
            ordersDetail.setQuantity(c.getQuantity());
            ordersDetailMapper.addOrdersDetail(ordersDetail);
        }
        cartMapper.deleteCartByUid(uid);
        return orders;
    }

    @Override
    public List<Orders> getOrders(Integer uid,Integer currentPage,Integer pageSize) {
        return ordersMapper.getOrders(uid,(currentPage -1)*pageSize,pageSize);
    }

    @Override
    public int getOrdersCount(Integer uid) {
        return ordersMapper.getOrdersCount(uid);
    }
}
