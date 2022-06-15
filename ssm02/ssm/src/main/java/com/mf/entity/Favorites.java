package com.mf.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Favorites {
    private Integer fid;
    private Integer uid;
    private Integer pid;
    private Date collectTime;
    private Product product;
}
