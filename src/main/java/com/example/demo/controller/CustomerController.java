package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customer")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public List<Customer> getCustomerById(@PathVariable String id){
        Integer customerId = Integer.parseInt(id);
        return customerRepository.findAllById(Set.of(customerId));
    }

//    @PostMapping("/customer")
//    public Flower create(@RequestBody Customer customer){
//        return customerRepository.save(customer);
//    }

    @PutMapping("/customer/{id}")
    Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable Integer id) {

        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setFullName(newCustomer.getFullName());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setPhoneNumber(newCustomer.getPhoneNumber());
                    customer.setBillingAddress(newCustomer.getBillingAddress());
                    return customerRepository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return customerRepository.save(newCustomer);
                });
    }


    @DeleteMapping("/customer/{id}")
    void deleteCustomer(@PathVariable Integer id) {
        customerRepository.deleteById(id);
    }

}
