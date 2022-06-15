package com.mf.service;

import com.mf.entity.Orders;

import java.util.List;

public interface OrdersService {
    public Orders addOrders(Integer uid);

    public List<Orders> getOrders(Integer uid, Integer currentPage, Integer pageSize);

    public int getOrdersCount(Integer uid);
}
