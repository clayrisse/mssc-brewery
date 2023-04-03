package com.microservices.brewery.web.controller.v2;

import ch.qos.logback.core.BasicStatusManager;
import com.microservices.brewery.services.v2.BeerServiceV2;
import com.microservices.brewery.web.model.BeerDto;
import com.microservices.brewery.web.model.v2.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Validated  //for the @NotNull
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    //We can take this out with the @RequiredArgsConstructor because it has a final variable
//    public BeerControllerV2(BeerServiceV2 beerService) {
//        this.beerServiceV2 = beerService;
//    }

    @GetMapping({"/{beerId}"})
    @CrossOrigin()
    public ResponseEntity<BeerDtoV2> getBeer2(@NotNull @PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping//Post - create new beer
    public ResponseEntity handlePost2(@Valid @NotNull @RequestBody BeerDtoV2 beerDto) {

        //Using @SL4j
        log.debug("in handle post... ");


//        BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDto); //example for val in lombok
//        HttpHeaders headers = new HttpHeaders(); //example for val in lombok

        val savedDto = beerServiceV2.saveNewBeer(beerDto);
        val headers = new HttpHeaders();

        //todo add hostname
        headers.add("Location","/api/v1/beer/" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUptade2(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto){
        beerServiceV2.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer2(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteById(beerId);
        System.err.println(beerId);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
        List<String> errors =  new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
