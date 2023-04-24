package com.microservices.brewery.web.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.SQLOutput;

@ActiveProfiles("snake")//makes tha variables in a sake way beer_dto. the defaullt is camel case
@JsonTest
public class BeerDtoSnakeTest extends BaseTest {


    @Test
    void testSnake() throws JsonProcessingException {
        BeerDto dto = getDto();
        String json = objectMapper.writeValueAsString(dto);

        System.out.println(json);


    }
}
