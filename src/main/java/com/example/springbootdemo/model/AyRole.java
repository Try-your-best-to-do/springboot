package com.example.springbootdemo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* 用户角色实体类
* ye
* 2020.11.10
* */
@Entity
@Table(name = "ay_role")
public class AyRole {
    @Id
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
