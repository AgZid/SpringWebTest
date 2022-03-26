package com.example.demo.controller;

import com.example.demo.model.Flower;
import com.example.demo.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class FlowerController {

    @Autowired
    FlowerRepository flowerRepository;

    @GetMapping("/flower")
    public List<Flower> getAllFlowers(){
        return flowerRepository.findAll();
    }

    @GetMapping("/flower/{id}")
    public List<Flower> getFlowerById(@PathVariable String id){
        Integer flowerId = Integer.parseInt(id);
        return flowerRepository.findAllById(Set.of(flowerId));
    }

//    @PostMapping("/flower")
//    public Flower create(@RequestBody Flower flower){
//        return flowerRepository.save(flower);
//    }

    @PutMapping("/flower/{id}")
    Flower updateFlower(@RequestBody Flower newFlower, @PathVariable Integer id) {

        return flowerRepository.findById(id)
                .map(flower -> {
                    flower.setName(newFlower.getName());
                    flower.setFlowerPrice(newFlower.getFlowerPrice());
                    return flowerRepository.save(flower);
                })
                .orElseGet(() -> {
                    newFlower.setFlower_id(id);
                    return flowerRepository.save(newFlower);
                });
    }


    @DeleteMapping("/flower/{id}")
    void deleteFlower(@PathVariable Integer id) {
        flowerRepository.deleteById(id);
    }

}