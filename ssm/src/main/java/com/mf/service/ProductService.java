package com.mf.service;

import com.mf.entity.Product;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct(String name, Integer currentPage, Integer pageSize);

    public Integer getProductCount(String pname);

    public void addProduct(Product product);

    public void deleteProduct(int pid);

    public void updateProduct(Product product);

    public Product getProductByName(String pname);

    public Product getProductById(int pid);
}
