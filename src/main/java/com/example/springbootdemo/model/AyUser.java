package com.example.springbootdemo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* 用户表
* Ye
* 2020.9.28
* */

@Entity
@Table(name = "ay_user")
public class AyUser {
    @Id
    private String id;

    private String name;

    private String password;

    private String mail;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "AyUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
