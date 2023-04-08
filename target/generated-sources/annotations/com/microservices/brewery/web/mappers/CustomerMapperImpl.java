package com.microservices.brewery.web.mappers;

import com.microservices.brewery.domain.Customer;
import com.microservices.brewery.web.model.CustomerDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-08T19:01:27+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto customerDtoToCustomer(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        return customerDto;
    }

    @Override
    public Customer customerToCustomerDto(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        return customer;
    }
}
