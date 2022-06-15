package com.mf.dao;

import com.mf.entity.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersMapper {
    @Insert("insert into orders (uid,totalMoney,createTime) values (#{uid},#{totalMoney},#{createTime})")
    @Options(useGeneratedKeys = true, keyColumn = "oid", keyProperty = "oid")
    public void addOrders(Orders orders);

    public List<Orders> getOrders(@Param("uid") Integer uid, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    public int getOrdersCount(Integer uid);
}
