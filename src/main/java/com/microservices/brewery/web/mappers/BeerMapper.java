package com.microservices.brewery.web.mappers;

import com.microservices.brewery.domain.Beer;
import com.microservices.brewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    BeerDto beerDtoToBeer(BeerDto beerDto);
}
