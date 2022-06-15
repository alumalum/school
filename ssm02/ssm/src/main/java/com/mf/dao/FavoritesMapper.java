package com.mf.dao;

import com.mf.entity.Favorites;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FavoritesMapper {
    public List<Favorites> getAllFavorites(Integer uid);

    @Insert("insert into favorites (uid,pid,collectTime) values (#{uid},#{pid},#{collectTime})")
    public void addFavorites(Favorites favorites);

    @Delete("delete from favorites where uid=#{uid} and pid=#{pid}")
    public void deleteFavorites(@Param("uid") Integer uid,@Param("pid") Integer pid);

    @Select("select * from favorites where uid=#{uid} and pid = #{pid}")
    public Favorites getOneFavorites(Favorites favorites);
}
