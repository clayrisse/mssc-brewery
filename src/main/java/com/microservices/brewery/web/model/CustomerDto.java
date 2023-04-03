package com.microservices.brewery.web.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    private UUID ID;

    @NotNull @Size(min=3, max=100 )
    private String customerName;

}
