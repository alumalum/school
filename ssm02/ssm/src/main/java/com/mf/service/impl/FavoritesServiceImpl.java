package com.mf.service.impl;

import com.mf.dao.FavoritesMapper;
import com.mf.entity.Favorites;
import com.mf.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class FavoritesServiceImpl implements FavoritesService {

    @Autowired
    FavoritesMapper favoritesMapper;

    @Override
    public List<Favorites> getAllCollect(Integer uid) {
        return favoritesMapper.getAllFavorites(uid);
    }

    @Override
    public void addCollect(Favorites favorites) {
        favoritesMapper.addFavorites(favorites);
    }

    @Override
    public void deleteFavorites(Integer uid, Integer pid) {
        favoritesMapper.deleteFavorites(uid,pid);
    }

    @Override
    public Favorites getOneFavorites(Favorites favorites) {
        return favoritesMapper.getOneFavorites(favorites);
    }
}
