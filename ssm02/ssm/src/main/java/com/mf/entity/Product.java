package com.mf.entity;

import lombok.Data;

@Data
public class Product {
    private Integer pid;
    private String pname;
    private Double price;
    private String fileName;
    private Integer stock;
    private Integer sortId;
    private Sort sort;
}
