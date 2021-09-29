package com.example.cars.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.cars.exceptions.ValidateException;
import com.example.cars.model.Car;
import org.junit.jupiter.api.Test;

class CarDtoTest {
    @Test
    void testFromCar() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");
        CarDto actualFromCarResult = CarDto.fromCar(car);
        assertEquals(1, actualFromCarResult.getHorsepower().intValue());
        assertEquals("Vendor-Model", actualFromCarResult.getModel());
        assertEquals(123L, actualFromCarResult.getId().longValue());
    }

    @Test
    void testToCar() throws ValidateException {
        CarDto carDto = new CarDto();
        carDto.setModel("Model");
        carDto.setId(123L);
        carDto.setOwnerId(123L);
        carDto.setHorsepower(1);
        assertThrows(ValidateException.class, () -> CarDto.toCar(carDto));
    }

    @Test
    void testToCar2() throws ValidateException {
        CarDto carDto = new CarDto();
        carDto.setModel("-");
        carDto.setId(123L);
        carDto.setOwnerId(123L);
        carDto.setHorsepower(1);
        Car actualToCarResult = CarDto.toCar(carDto);
        assertEquals(1, actualToCarResult.getHorsepower().intValue());
        assertEquals("", actualToCarResult.getVendor());
        assertEquals(123L, actualToCarResult.getPerson_id().longValue());
        assertEquals("", actualToCarResult.getModel());
        assertEquals(123L, actualToCarResult.getId().longValue());
    }

    @Test
    void testToCar3() throws ValidateException {
        CarDto carDto = new CarDto();
        carDto.setModel("Model");
        carDto.setId(null);
        carDto.setOwnerId(123L);
        carDto.setHorsepower(1);
        assertThrows(ValidateException.class, () -> CarDto.toCar(carDto));
    }

    @Test
    void testToCar4() throws ValidateException {
        CarDto carDto = new CarDto();
        carDto.setModel("Model");
        carDto.setId(123L);
        carDto.setOwnerId(null);
        carDto.setHorsepower(1);
        assertThrows(ValidateException.class, () -> CarDto.toCar(carDto));
    }

    @Test
    void testToCar5() throws ValidateException {
        CarDto carDto = new CarDto();
        carDto.setModel("Model");
        carDto.setId(123L);
        carDto.setOwnerId(123L);
        carDto.setHorsepower(0);
        assertThrows(ValidateException.class, () -> CarDto.toCar(carDto));
    }
}

