package com.mf.dao;


import com.mf.entity.OrdersDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersDetailMapper {
    @Insert("insert into orders_detail (oid,quantity,price,pname,pid) values (#{oid},#{quantity},#{price},#{pname},#{pid})")
    public void addOrdersDetail(OrdersDetail ordersDetail);

    @Select("select * from orders_detail where oid = #{oid}")
    public List<OrdersDetail> getAllOrdersDetailByOid(Integer oid);
}
