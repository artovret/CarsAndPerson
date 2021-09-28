package com.example.cars.dto;

import com.example.cars.exceptions.ValidateException;
import com.example.cars.model.Car;
import com.example.cars.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDto {
    private Long id;
    private String model;
    private Integer horsepower;
    private Long person;

    public static CarDto fromCar(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setModel(car.getModel());
        carDto.setHorsepower(car.getHorsepower());
        //carDto.setPerson(car.getPerson());
        return carDto;
    }

    public static Car toCar(CarDto carDto) throws ValidateException {
        if (carDto.getHorsepower() < 0) {
            throw new ValidateException("Ошибка валидации");
        }
        Car car = new Car();
        car.setId(carDto.getId());
        car.setModel(carDto.getModel());
        car.setHorsepower(carDto.getHorsepower());
        car.setPerson_id(carDto.getPerson());
        return car;
    }
}
