package com.mf.service;

import com.mf.entity.Cart;


import java.util.List;

public interface CartService {
    public List<Cart> getCartByUid(Integer id, Integer currentPage, Integer pageSize);

    public void addCart(Cart cart);

    public Integer getCartCount(Integer id);

    public void deleteCart(Cart cart);

    public void updateCartQuantity(Cart cart);

    public Cart getCartByUidAndPid(Cart cart);

    public Integer getUserCartCount(Integer uid);
}
