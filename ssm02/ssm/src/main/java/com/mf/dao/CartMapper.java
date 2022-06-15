package com.mf.dao;

import com.mf.entity.Cart;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartMapper {
    public List<Cart> getCartByUid(@Param("uid") Integer id, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    @Insert("insert into cart (uid,pid,quantity) values (#{uid},#{pid},#{quantity})")
    public void addCart(Cart cart);

    public Integer getCartCount(Integer id);

    @Delete("delete from cart where uid=#{uid} and pid=#{pid}")
    public void deleteCart(Cart cart);

    @Update("update cart set quantity = #{quantity} where uid=#{uid} and pid=#{pid}")
    public void updateCartQuantity(Cart cart);

    @Select("select * from cart where uid=#{uid} and pid=#{pid}")
    public Cart getCartByUidAndPid(Cart cart);

    @Delete("delete from cart where uid=#{uid}")
    public void deleteCartByUid(Integer uid);

    @Select("SELECT COUNT(pid) counts FROM cart WHERE uid = #{uid}")
    public Integer getUserCartCount(Integer uid);
}
