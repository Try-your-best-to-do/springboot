package com.example.springbootdemo.model;


/*
* ye
* 监听表
* 2020.10.15
*
* */

import javax.persistence.*;

@Entity
@Table(name = "listener")
public class Listener {

    @Id
    private String id;
    private Integer quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Listener{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
