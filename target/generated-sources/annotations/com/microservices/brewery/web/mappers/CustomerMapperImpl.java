package com.microservices.brewery.web.mappers;

import com.microservices.brewery.domain.Customer;
import com.microservices.brewery.domain.Customer.CustomerBuilder;
import com.microservices.brewery.web.model.CustomerDto;
import com.microservices.brewery.web.model.CustomerDto.CustomerDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-03T21:52:52+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto customerDtoToCustomer(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDtoBuilder customerDto = CustomerDto.builder();

        customerDto.ID( customer.getID() );
        customerDto.customerName( customer.getCustomerName() );

        return customerDto.build();
    }

    @Override
    public Customer customerToCustomerDto(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        CustomerBuilder customer = Customer.builder();

        customer.ID( customerDto.getID() );
        customer.customerName( customerDto.getCustomerName() );

        return customer.build();
    }
}
