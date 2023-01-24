package com.sofka.retobackend.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;

@Document(collection = "buys")
public class Buy {

    @Id
    private String id;

    private LocalDate date;

    private String idType;

    private String idNumber;

    private String clientName;

    private ArrayList<Product> products;

    public Buy() {
    }

    public Buy(String id, LocalDate date, String idType, String idNumber, String clientName, ArrayList<Product> products) {
        this.id = id;
        this.date = date;
        this.idType = idType;
        this.idNumber = idNumber;
        this.clientName = clientName;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", idType='" + idType + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", clientName='" + clientName + '\'' +
                ", products=" + products +
                '}';
    }
}
