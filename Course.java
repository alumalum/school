package com.pojo;

import java.io.Serializable;

public class Course implements Serializable {
    private int id;//主键
    private String name;//课程名
    private String teacherId;//老师id

    public Course() {
    }

    public Course(String name, String teacherId) {
        this.name = name;
        this.teacherId = teacherId;
    }

    public Course(int id, String name, String teacherId) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + teacherId;
    }
}
