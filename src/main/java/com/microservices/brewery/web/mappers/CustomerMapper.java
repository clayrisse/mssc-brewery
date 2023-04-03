package com.microservices.brewery.web.mappers;

import com.microservices.brewery.domain.Customer;
import com.microservices.brewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerDtoToCustomer(Customer customer);
    Customer customerToCustomerDto(CustomerDto customerDto);
}
