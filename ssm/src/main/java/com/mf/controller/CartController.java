package com.mf.controller;

import com.mf.Until.Pages;
import com.mf.entity.Cart;
import com.mf.entity.User;
import com.mf.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping("/getAllCart")
    public String getAllCart(Integer id, Integer currentPage, HttpSession session, HttpServletRequest request) {
        System.out.println("-----------getAllCart-------------");
        if (currentPage == null) {
            currentPage = 1;
        }
        User user = (User) session.getAttribute("user");
        Pages pages = new Pages();
        pages.setTotalCount(cartService.getCartCount(user.getUid()));
        pages.setCurrentPage(currentPage);
        List<Cart> cartList = cartService.getCartByUid(user.getUid(), currentPage, pages.getPageSize());
        double totalMoney = 0;
        for (Cart c : cartList) {
            totalMoney += (c.getProduct().getPrice() * c.getQuantity());
        }
        request.setAttribute("cartList", cartList);
        request.setAttribute("pages", pages);
        request.setAttribute("totalMoney",totalMoney);
        return "cartList";
    }

    @RequestMapping("/addCart")
    public String addCart(Integer pid, Integer quantity, HttpSession session) {
        System.out.println("-----------addCart-------------");
        User user = (User) session.getAttribute("user");
        Cart cart = new Cart();
        cart.setUid(user.getUid());
        cart.setPid(pid);
        cart.setQuantity(quantity);
        cartService.addCart(cart);
        return "redirect:/cart/getAllCart";
    }

    @RequestMapping("/deleteCart")
    public String deleteCart(Integer pid, HttpSession session) {
        System.out.println("-----------deleteCart-------------");
        User user = (User) session.getAttribute("user");
        Cart cart = new Cart();
        cart.setPid(pid);
        cart.setUid(user.getUid());
        cartService.deleteCart(cart);
        return "redirect:/cart/getAllCart";
    }

    @RequestMapping("/updateCartQuantity")
    public String updateCartQuantity(Integer pid, Integer quantity, HttpSession session) {
        System.out.println("-----------updateCartQuantity-------------");
        User user = (User) session.getAttribute("user");
        Cart cart = new Cart();
        cart.setPid(pid);
        cart.setUid(user.getUid());
        Cart c = cartService.getCartByUidAndPid(cart);
        int num = c.getQuantity();
        if (num == 1 && quantity == -1) {
            cartService.deleteCart(c);
        } else {
            c.setQuantity(c.getQuantity() + quantity);
            cartService.updateCartQuantity(c);
        }
        return "redirect:/cart/getAllCart";
    }
}
