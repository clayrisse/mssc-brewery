package com.microservices.brewery.web.mappers;

import com.microservices.brewery.domain.Beer;
import com.microservices.brewery.web.model.BeerDto;
import com.microservices.brewery.web.model.BeerDto.BeerDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-03T21:23:21+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoBuilder beerDto = BeerDto.builder();

        beerDto.id( beer.getId() );
        if ( beer.getBeerStyle() != null ) {
            beerDto.beerStyle( beer.getBeerStyle().name() );
        }
        beerDto.upc( beer.getUpc() );

        return beerDto.build();
    }

    @Override
    public BeerDto beerDtoToBeer(BeerDto beerDto) {
        if ( beerDto == null ) {
            return null;
        }

        BeerDtoBuilder beerDto1 = BeerDto.builder();

        beerDto1.id( beerDto.getId() );
        beerDto1.beerName( beerDto.getBeerName() );
        beerDto1.beerStyle( beerDto.getBeerStyle() );
        beerDto1.upc( beerDto.getUpc() );

        return beerDto1.build();
    }
}
