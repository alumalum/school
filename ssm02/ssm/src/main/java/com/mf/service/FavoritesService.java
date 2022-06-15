package com.mf.service;

import com.mf.entity.Favorites;


import java.util.List;

public interface FavoritesService {
    public List<Favorites> getAllCollect(Integer uid);

    public void addCollect(Favorites favorites);

    public void deleteFavorites(Integer uid, Integer pid);

    public Favorites getOneFavorites(Favorites favorites);
}
