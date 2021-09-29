package com.example.cars.service;

import com.example.cars.model.Car;
import com.example.cars.model.Person;

import java.util.Optional;

public interface PersonService {

    Person put(Person person);

    Car put(Car car);

    void delete();

    Optional<Person> findById(long id);

    Long getPersonCount();

    Long getCarCount();

    Long getVendorCount();

}
