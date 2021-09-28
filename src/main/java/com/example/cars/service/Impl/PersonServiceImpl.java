package com.example.cars.service.Impl;

import com.example.cars.model.Car;
import com.example.cars.model.Message;
import com.example.cars.model.Person;
import com.example.cars.repository.CarRepository;
import com.example.cars.repository.PersonRepository;
import com.example.cars.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
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
        //carRepository.deleteAll();
    }
//
//    @Override
//    public Message peek() {
//        log.warn("peek()");
//        return personRepository.findTopByOrderByIdAsc();
//    }
//
//    @Override
//    public Message peekMax() {
//        log.warn("peekMax()");
//        return personRepository.findTopOrderByMsgLength();
//        //return null;
//    }
//
//    @Override
//    public List<Message> all() {
//        return personRepository.findAll();
//    }
}
