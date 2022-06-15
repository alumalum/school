package com.mf.dao;

import com.mf.entity.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersMapper {
    @Insert("insert into orders (uid,totalMoney,createTime,state) values (#{uid},#{totalMoney},#{createTime},#{state})")
    @Options(useGeneratedKeys = true, keyColumn = "oid", keyProperty = "oid")
    public void addOrders(Orders orders);

    public List<Orders> getOrders(@Param("uid") Integer uid, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    public int getOrdersCount(Integer uid);
    @Update("update orders set state = #{state} where oid = #{oid}")
    public void updateOrdersState(@Param("oid") Integer oid,@Param("state") String state);
    @Select("select * from orders where oid = #{oid}")
    public Orders getOrdersOne(Integer oid);
}
