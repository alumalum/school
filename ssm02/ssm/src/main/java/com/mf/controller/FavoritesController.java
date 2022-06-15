package com.mf.controller;

import com.mf.entity.Favorites;
import com.mf.entity.User;
import com.mf.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/favorites")
public class FavoritesController {

    @Autowired
    FavoritesService favoritesService;

    @RequestMapping("/addCollect")
    public String addCollect(Integer pid, HttpSession session){
        User user = (User)session.getAttribute("user");
        Favorites favorites = new Favorites();
        favorites.setUid(user.getUid());
        favorites.setCollectTime(new Date());
        favorites.setPid(pid);
        Favorites f1 = favoritesService.getOneFavorites(favorites);
        if(f1 != null){
            favoritesService.deleteFavorites(user.getUid(),pid);
        }else {
            favoritesService.addCollect(favorites);
        }
        return "redirect:/favorites/getAllFavorites";
    }

    @RequestMapping("/getAllFavorites")
    public String getAllFavorites(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Favorites> favoritesList = favoritesService.getAllCollect(user.getUid());
        request.setAttribute("favoritesList",favoritesList);
        return "favoritesList";
    }

    @RequestMapping("/deleteFavorites")
    public String deleteFavorites(HttpSession session,Integer pid){
        User user = (User)session.getAttribute("user");
        favoritesService.deleteFavorites(user.getUid(),pid);
        return "redirect:/favorites/getAllFavorites";
    }
}
