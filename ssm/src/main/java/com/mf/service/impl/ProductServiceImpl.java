package com.mf.service.impl;

import com.mf.dao.ProductMapper;
import com.mf.entity.Product;
import com.mf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> getAllProduct(String name, Integer currentPage, Integer pageSize) {
        return productMapper.getAllProduct(name, (currentPage - 1) * pageSize, pageSize);
    }

    @Override
    public Integer getProductCount(String pname) {
        return productMapper.getProductCount(pname);
    }

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public void deleteProduct(int pid) {
        productMapper.deleteProduct(pid);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public Product getProductByName(String pname) {
        return productMapper.getProductByName(pname);
    }

    @Override
    public Product getProductById(int pid) {
        return productMapper.getProductById(pid);
    }
}
