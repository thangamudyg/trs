package com.trs.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Receipt")
public class Receipt {
    @Id
    @GeneratedValue
    private int receipt_id;
    private int user_id;
    private String from_station;
    private String to_station;
    private double price;

    public int getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(int receipt_id) {
        this.receipt_id = receipt_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFrom_station() {
        return from_station;
    }

    public void setFrom_station(String from_station) {
        this.from_station = from_station;
    }

    public String getTo_station() {
        return to_station;
    }

    public void setTo_station(String to_station) {
        this.to_station = to_station;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
