package com.mf.controller;

import com.mf.Until.Pages;
import com.mf.entity.Product;
import com.mf.entity.User;
import com.mf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/getAllProduct")
    public String getAllProduct(String name, Integer currentPage, HttpServletRequest request) {
        System.out.println("----------getAllProduct------------");
        System.out.println("currentPage: " + currentPage);
        if ("".equals(name)) {
            name = null;
        }
        if (currentPage == null) {
            currentPage = 1;
        }
        Pages pages = new Pages();
        pages.setTotalCount(productService.getProductCount(name));
        pages.setCurrentPage(currentPage);
        List<Product> productList = productService.getAllProduct(name, currentPage, pages.getPageSize());
        request.setAttribute("productList", productList);
        request.setAttribute("pages", pages);
        request.setAttribute("name", name);
        return "public";
    }

    @RequestMapping("/getAllProductAdmin")
    public String getAllProductAdmin(String name, Integer currentPage, HttpServletRequest request) {
        System.out.println("----------getAllProductAdmin------------");
        if ("".equals(name)) {
            name = null;
        }
        if (currentPage == null) {
            currentPage = 1;
        }
        Pages pages = new Pages();
        pages.setTotalCount(productService.getProductCount(name));
        pages.setCurrentPage(currentPage);
        List<Product> productList = productService.getAllProduct(name, currentPage, pages.getPageSize());
        request.setAttribute("productList", productList);
        request.setAttribute("pages", pages);
        request.setAttribute("name", name);
        return "productList";
    }

    @RequestMapping("/checkProductName")
    @ResponseBody
    public Boolean checkProductName(String name) {
        System.out.println("----------checkProductName-----------");
        System.out.println("name:" + name);
        Product product = productService.getProductByName(name);
        System.out.println(product);
        if (product != null) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("/addProduct")
    public String addProduct(Product product, MultipartFile files, HttpServletRequest request) {
        String contexPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("项目路径" + contexPath);
        File filePath = new File(contexPath + "images\\");
        System.out.println("文件原名：" + files.getOriginalFilename());
        String fileName = UUID.randomUUID() + "--" + files.getOriginalFilename();
        System.out.println("文件名" + fileName);
        try {
            files.transferTo(new File(filePath, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setFileName(fileName);
        productService.addProduct(product);
        return "redirect:/product/getAllProductAdmin";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(Integer pid){
        System.out.println("------------deleteProduct-------------");
        productService.deleteProduct(pid);
        return "redirect:/product/getAllProductAdmin";
    }
    @RequestMapping("toUpdateProduct")
    public String toUpdateProduct(Integer pid,HttpServletRequest request){
        System.out.println("------------toUpdateProduct-------------");
        Product product = productService.getProductById(pid);
        request.setAttribute("product",product);
        return "updateProduct";
    }
    @RequestMapping("/updateProduct")
    public String updateProduct(Product product,MultipartFile files,HttpServletRequest request){
        System.out.println("------------updateProduct-------------");
        String contexPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("项目路径" + contexPath);
        File filePath = new File(contexPath + "images\\");
        System.out.println("文件原名：" + files.getOriginalFilename());
        String fileName = UUID.randomUUID() + "--" + files.getOriginalFilename();
        System.out.println("文件名" + fileName);
        try {
            files.transferTo(new File(filePath, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setFileName(fileName);
        System.out.println(product);
        productService.updateProduct(product);
        return "redirect:/product/getAllProductAdmin";
    }
}
