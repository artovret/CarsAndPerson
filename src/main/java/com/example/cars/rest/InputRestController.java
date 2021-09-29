package com.example.cars.rest;


import com.example.cars.dto.CarDto;
import com.example.cars.dto.PersonDto;
import com.example.cars.exceptions.ValidateException;
import com.example.cars.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@Slf4j
@RequiredArgsConstructor
public class InputRestController {
    private final PersonService personService;

    @PostMapping("/car")
    public ResponseEntity addCar(@RequestBody CarDto carDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            if (personService.findCarById(carDto.getId()).isPresent()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            response.put("car", personService.put(CarDto.toCar(carDto)));
            return ResponseEntity.ok(response);
        } catch (ValidateException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/person")
    public ResponseEntity addPerson(@RequestBody PersonDto personDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            if (personService.findById(personDto.getId()).isPresent()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            response.put("person", personService.put(PersonDto.toPerson(personDto)));
            return ResponseEntity.ok(response);
        } catch (ValidateException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
