package com.trs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Train")
public class Train {
    @Id
    @GeneratedValue
    private int id;
    private String train_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }
}
