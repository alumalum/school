package com.pojo;

import java.io.Serializable;

public class Professional implements Serializable {
    private int id;//职称id
    private String name;//职称名

    public Professional() {
    }

    public Professional(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "\t" + name;
    }
}
