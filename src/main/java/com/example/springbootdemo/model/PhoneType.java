package com.example.springbootdemo.model;
/*
* 电话表
*  Ye
* 2020.9.29
*
* */
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="phone_type")
public class PhoneType implements Serializable {
    private String type_id;
    private String number_part;
    private String type_name;
    private String type_remark;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getNumber_part() {
        return number_part;
    }

    public void setNumber_part(String number_part) {
        this.number_part = number_part;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getType_remark() {
        return type_remark;
    }

    public void setType_remark(String type_remark) {
        this.type_remark = type_remark;
    }

    @Override
    public String toString() {
        return "PhoneType{" +
                "type_id='" + type_id + '\'' +
                ", number_part='" + number_part + '\'' +
                ", type_name='" + type_name + '\'' +
                ", type_remark='" + type_remark + '\'' +
                '}';
    }
}
