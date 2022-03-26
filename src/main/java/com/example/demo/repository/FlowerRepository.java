package com.example.demo.repository;

import com.example.demo.model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Integer> {

//    List<Flower> findByTextContaining(String text);

}
