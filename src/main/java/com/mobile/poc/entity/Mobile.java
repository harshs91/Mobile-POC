package com.mobile.poc.entity;

import javax.persistence.*;

@Entity
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String modelName;

    private String brandName;

    public Mobile() {
    }

    public Mobile(int id, String modelName, String brandName) {
        this.id = id;
        this.modelName = modelName;
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
