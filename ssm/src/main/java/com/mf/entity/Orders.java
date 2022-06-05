package com.mf.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {
    private Integer oid;
    private Integer uid;
    private Double totalMoney;
    private Date createTime;
}
