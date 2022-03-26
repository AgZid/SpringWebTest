package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FlowersOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flowerOrder_id;

    // private boolean status;
    private String orderDate;
    private String orderDeadlineDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flowerOrders")
    private List<Flower> flowers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Customer customer;

}
