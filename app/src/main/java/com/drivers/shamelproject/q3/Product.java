package com.drivers.shamelproject.q3;

public class Product {
    String  name,price,qyt;

    public Product(String name, String price, String qyt) {
        this.name = name;
        this.price = price;
        this.qyt = qyt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQyt() {
        return qyt;
    }

    public void setQyt(String qyt) {
        this.qyt = qyt;
    }
}
