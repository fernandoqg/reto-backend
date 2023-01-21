package com.sofka.retobackend.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

     @Id
     private String id;

     private String name;

     private int price;

     private int inInventory;

     private boolean enable;

     private int min;

     private int max;

    public Product() {

    }

    public Product(String id, String name, int price, int inInventory, boolean enable, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inInventory = inInventory;
        this.enable = enable;
        this.min = min;
        this.max = max;
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInInventory() {
        return inInventory;
    }

    public void setInInventory(int inInventory) {
        this.inInventory = inInventory;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inInventory=" + inInventory +
                ", enable=" + enable +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
