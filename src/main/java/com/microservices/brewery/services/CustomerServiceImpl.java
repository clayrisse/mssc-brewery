package com.microservices.brewery.services;

import com.microservices.brewery.web.model.BeerDto;
import com.microservices.brewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .ID(UUID.randomUUID())
                .customerName("Pepito")
                .build();
    }
}
