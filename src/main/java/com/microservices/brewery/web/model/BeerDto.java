package com.microservices.brewery.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.microservices.brewery.domain.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @JsonProperty("beerId")// this overwrites the property name to beerId
    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:Z", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;
    private OffsetDateTime lastUpdatedDate;

//    this property price is for jackson example
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate myLocalDate;
}