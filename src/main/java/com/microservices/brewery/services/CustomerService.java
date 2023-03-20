package com.microservices.brewery.services;

import com.microservices.brewery.web.model.BeerDto;
import com.microservices.brewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);


}
