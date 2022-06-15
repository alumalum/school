package com.mf.service;

import com.mf.entity.Product;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct(String name, Integer sortId, Integer currentPage, Integer pageSize);

    public Integer getProductCount(String pname,Integer sortId);

    public void addProduct(Product product);

    public void deleteProduct(int pid);

    public void updateProduct(Product product);

    public Product getProductByName(String pname);

    public Product getProductById(int pid);

    public void updateProductStock(Integer pid,Integer stock);
}
