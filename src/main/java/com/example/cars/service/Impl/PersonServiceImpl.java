package com.example.cars.service.Impl;

import com.example.cars.model.Car;
import com.example.cars.model.Person;
import com.example.cars.repository.CarRepository;
import com.example.cars.repository.PersonRepository;
import com.example.cars.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    @Override
    public Person put(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public Car put(Car car) {
        carRepository.save(car);
        return car;
    }

    @Override
    public void delete() {
        personRepository.deleteAll();
    }

    @Override
    public Optional<Person> findById(long id) {
        return personRepository.findById(id);
    }

    @Override
    public Long getPersonCount() {
        return personRepository.count();
    }

    @Override
    public Long getCarCount() {
        return carRepository.count();
    }

    @Override
    public Long getVendorCount() {
        Set<String> vendors = new HashSet<>();
        carRepository.findAll().forEach(vendor -> vendors.add(vendor.getVendor()));
        return (long) vendors.size();
    }

    @Override
    public Optional<Car> findCarById(long id) {
        return carRepository.findById(id);
    }
}
