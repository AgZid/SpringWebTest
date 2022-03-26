package com.example.demo.repository;

import com.example.demo.model.FlowersOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowersOrderRepository extends JpaRepository<FlowersOrder, Integer> {
}

