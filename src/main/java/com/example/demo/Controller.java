package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Customer")
public class Controller {
    private CustomerRepository customerRepository;

    public Controller(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(value= "/all")
    public List<Customer> getAll(){
        List<Customer> customers=this.customerRepository.findAll();
        return customers;


    }
    @PutMapping
    public void insert(@RequestBody Customer customer){
        this.customerRepository.insert(customer);
    }
    @PostMapping
    public void update(@RequestBody Customer customer){
        this.customerRepository.save(customer);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        this.customerRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Customer> getById(@PathVariable("id") String id){
        Optional<Customer> customer =this.customerRepository.findById(id);
        return customer;
    }
}
