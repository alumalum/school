package com.mf.entity;

import lombok.Data;

@Data
public class OrdersDetail {
    private Integer id;
    private Integer oid;
    private Integer quantity;
    private Double price;
    private String pname;
}
