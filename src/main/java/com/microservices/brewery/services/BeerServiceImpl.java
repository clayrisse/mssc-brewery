package com.microservices.brewery.services;

import com.microservices.brewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Gato Galactico")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
//                .beerStyle("xxx")
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        //todo impl- would add a real impl to update beer
    }

    @Override
    public void deleteById(UUID beerId) {
        //todo impl
        log.debug("....deleting a beer...");
    }
}

