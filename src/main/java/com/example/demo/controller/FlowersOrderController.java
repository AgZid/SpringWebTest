package com.example.demo.controller;

import com.example.demo.model.FlowersOrder;
import com.example.demo.repository.FlowersOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class FlowersOrderController {

    @Autowired
    FlowersOrderRepository flowersOrderRepository;

    @GetMapping("/flowersOrder")
    public List<FlowersOrder> getAllFlowersOrders(){
        return flowersOrderRepository.findAll();
    }

    @GetMapping("/flowersOrder/{id}")
    public List<FlowersOrder> getFlowersOrderById(@PathVariable String id){
        Integer flowersOrderId = Integer.parseInt(id);
        return flowersOrderRepository.findAllById(Set.of(flowersOrderId));
    }


    @PutMapping("/flowersOrder/{id}")
    FlowersOrder updateFlowersOrder(@RequestBody FlowersOrder newflowersOrder, @PathVariable Integer id) {

        return flowersOrderRepository.findById(id)
                .map(flowersOrder -> {
                    flowersOrder.setOrderDate(newflowersOrder.getOrderDate());
                    flowersOrder.setOrderDeadlineDate(newflowersOrder.getOrderDeadlineDate());
                    flowersOrder.setFlowers(newflowersOrder.getFlowers());
                    flowersOrder.setCustomer(newflowersOrder.getCustomer());
                    return flowersOrderRepository.save(flowersOrder);
                })
                .orElseGet(() -> {
                    newflowersOrder.setFlowerOrder_id(id);
                    return flowersOrderRepository.save(newflowersOrder);
                });
    }

    @DeleteMapping("/flowersOrder/{id}")
    void deleteFlowersOrder(@PathVariable Integer id) {
        flowersOrderRepository.deleteById(id);
    }

}
