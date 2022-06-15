package com.mf.service.impl;

import com.mf.dao.OrdersDetailMapper;
import com.mf.entity.OrdersDetail;
import com.mf.service.OrdersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersDetailServiceImpl implements OrdersDetailService {

    @Autowired
    OrdersDetailMapper ordersDetailMapper;

    @Override
    public void addOrdersDetail(OrdersDetail ordersDetail) {
        ordersDetailMapper.addOrdersDetail(ordersDetail);
    }

    @Override
    public List<OrdersDetail> getAllOrdersDetailByOid(Integer oid) {
        return ordersDetailMapper.getAllOrdersDetailByOid(oid);
    }
}
