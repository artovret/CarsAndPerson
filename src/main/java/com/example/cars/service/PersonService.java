package com.example.cars.service;

import com.example.cars.model.Car;
import com.example.cars.model.Message;
import com.example.cars.model.Person;

import java.util.List;

public interface PersonService {

    Person put(Person person);

    Car put(Car car);

    void delete();

//    Message poll();
//
//    Message peek();
//
//    Message peekMax();
//
//    List<Message> all();

}
