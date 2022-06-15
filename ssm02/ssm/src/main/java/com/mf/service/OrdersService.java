package com.mf.service;

import com.mf.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersService {
    public Orders addOrders(Integer uid);

    public List<Orders> getOrders(Integer uid, Integer currentPage, Integer pageSize);

    public int getOrdersCount(Integer uid);

    public void updateOrdersState(Integer oid, String state);

    public Orders getOrdersOne(Integer oid);
}
