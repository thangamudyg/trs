package com.trs.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Receipt")
public class Receipt {
    @Id
    @GeneratedValue
    private int receipt_id;
    private int user_id;
    private String from_station;
    private String to_station;
    private double price;
}
