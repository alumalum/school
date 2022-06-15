package com.mf.entity;

import lombok.Data;


@Data
public class Cart {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Integer quantity;
    private Product product;
}
