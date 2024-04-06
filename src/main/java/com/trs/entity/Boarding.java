package com.trs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Boarding")
public class Boarding {
    @Id
    @GeneratedValue
    private int id;
    private int train_number;
    private String from_station;
    private String to_station;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrain_number() {
        return train_number;
    }

    public void setTrain_number(int train_number) {
        this.train_number = train_number;
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
}
