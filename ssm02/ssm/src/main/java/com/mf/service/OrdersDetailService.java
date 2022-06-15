package com.mf.service;

import com.mf.entity.OrdersDetail;

import java.util.List;

public interface OrdersDetailService {
    public void addOrdersDetail(OrdersDetail ordersDetail);

    public List<OrdersDetail> getAllOrdersDetailByOid(Integer oid);
}
