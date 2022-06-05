package com.mf.service.impl;

import com.mf.dao.CartMapper;
import com.mf.entity.Cart;
import com.mf.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Override
    public List<Cart> getCartByUid(Integer id, Integer currentPage, Integer pageSize) {
        return cartMapper.getCartByUid(id, (currentPage - 1) * pageSize, pageSize);
    }

    @Override
    public void addCart(Cart cart) {
        Cart c = cartMapper.getCartByUidAndPid(cart);
        if (c != null) {
            int quantity = c.getQuantity() + cart.getQuantity();
            cart.setQuantity(quantity);
            cartMapper.updateCartQuantity(cart);
        } else {
            cartMapper.addCart(cart);
        }
    }

    @Override
    public Integer getCartCount(Integer id) {
        return cartMapper.getCartCount(id);
    }

    @Override
    public void deleteCart(Cart cart) {
        cartMapper.deleteCart(cart);
    }

    @Override
    public void updateCartQuantity(Cart cart) {
        cartMapper.updateCartQuantity(cart);
    }

    @Override
    public Cart getCartByUidAndPid(Cart cart) {
        return cartMapper.getCartByUidAndPid(cart);
    }
}
