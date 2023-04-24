package com.microservices.brewery.web.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

//import static org.junit.jupiter.api.Assertions.*;

@JsonTest // for json enviorment
class BeerDtoTest extends BaseTest {


    @Test
    void testSerialDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();
        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.err.println(jsonString);
    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"id\":\"4118e9ee-3ecd-475b-9089-e21915bbbdf0\",\"beerName\":\"algo\",\"beerStyle\":\"Ale\",\"upc\":123123123123123,\"createdDate\":\"2023-04-09T11:30:13.4401695+02:00\",\"lastUpdatedDate\":\"2023-04-09T11:30:13.4421716+02:00\",\"price\":12.99}\n";
        BeerDto  dto = objectMapper.readValue(json,BeerDto.class);

        System.err.println(dto);
    }

}