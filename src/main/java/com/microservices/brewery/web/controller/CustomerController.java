package com.microservices.brewery.web.controller;

import com.microservices.brewery.services.BeerService;
import com.microservices.brewery.services.CustomerService;
import com.microservices.brewery.web.model.BeerDto;
import com.microservices.brewery.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCostumerById(@PathVariable("customerId") UUID customerId) {
        System.out.println("customer");
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }


}
