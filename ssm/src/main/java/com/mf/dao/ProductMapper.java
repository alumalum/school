package com.mf.dao;

import com.mf.entity.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductMapper {
    public List<Product> getAllProduct(@Param("pname") String pname, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    public int getProductCount(String pname);

    @Insert("insert into product (pname,price,fileName) values (#{pname},#{price},#{fileName})")
    public void addProduct(Product product);

    @Delete("delete from product where pid = #{pid}")
    public void deleteProduct(int pid);

    @Update("update product set pname = #{pname},price = #{price},fileName = #{fileName} where pid = #{pid}")
    public void updateProduct(Product product);

    @Select("select * from product where pname = #{pname}")
    public Product getProductByName(String pname);

    @Select("select * from product where pid = #{pid}")
    public Product getProductById(int pid);
}
