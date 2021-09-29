package com.example.cars.dto;

import com.example.cars.exceptions.ValidateException;
import com.example.cars.model.Car;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDto {
    private Long id;
    private String model;
    private Integer horsepower;
    private Long ownerId;

    public static CarDto fromCar(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setModel(car.getVendor() + "-" + car.getModel());
        carDto.setHorsepower(car.getHorsepower());
        return carDto;
    }

    public static Car toCar(CarDto carDto) throws ValidateException {
        if (carDto.getHorsepower() <= 0 ||
                carDto.getHorsepower() == null ||
                carDto.getOwnerId() == null ||
                carDto.getId() == null ||
                !carDto.getModel().contains("-")
        ) {
            throw new ValidateException("Ошибка валидации");
        }
        Car car = new Car();
        car.setId(carDto.getId());
        String[] fullModel = carDto.getModel().split("-", 2);
        car.setVendor(fullModel[0]);
        car.setModel(fullModel[1]);
        car.setHorsepower(carDto.getHorsepower());
        car.setPerson_id(carDto.getOwnerId());
        return car;
    }
}
