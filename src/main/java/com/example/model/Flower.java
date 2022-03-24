package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flower_id;
    private String name;
    private Double flowerPrice;
    private String intakeDate;
    private String expires;
    private Integer amount;
    // private Integer suppler_id;
    private double length;
    private String color;

    @ManyToOne
    @JoinColumn(name = "flowerOrder_id")
    private FlowersOrder flowerOrder_id;
}