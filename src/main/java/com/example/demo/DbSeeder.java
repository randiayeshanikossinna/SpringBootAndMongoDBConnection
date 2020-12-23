package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;


@Component
public class DbSeeder implements CommandLineRunner {
 private CustomerRepository customerRepository;
    private Customer Randi;
    private Customer Thilina;
    private Customer Dineth;


    public DbSeeder(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Customer c1 = new Customer(
                "001",
                "Randi",
                "abc@gmail.com",
                "1234"
        );
        Customer c2 = new Customer(
                "002",
                "Thilina",
                "def@gmail.com",
                "5678"
        );
        Customer c3 = new Customer(
                "003",
                "Dineth",
                "ghi@gmail.com",
                "91011"
        );

        Customer c4 = new Customer(
                "004",
                "Joshiya",
                "jkl@gmail.com",
                "1213"
        );

        //drop all Customer
        this.customerRepository.deleteAll();

        //add customers into database
        //List<Customer> customers= Arrays.asList(Randi,Thilina,Dineth);
        //this.customerRepository.saveAll(customers);

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
        customerRepository.save(c4);

        System.out.println("*****************************");

        List<Customer> customers = customerRepository.findAll();

        for (Customer c : customers) {

            System.out.println(c.toString());


        }

    }}
