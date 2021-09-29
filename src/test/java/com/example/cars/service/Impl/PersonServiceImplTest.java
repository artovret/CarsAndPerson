package com.example.cars.service.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.cars.model.Car;
import com.example.cars.model.Person;
import com.example.cars.repository.CarRepository;
import com.example.cars.repository.PersonRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PersonServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PersonServiceImplTest {
    @MockBean(name = "cars")
    private CarRepository carRepository;

    @MockBean(name = "persons")
    private PersonRepository personRepository;

    @Autowired
    private PersonServiceImpl personServiceImpl;

    @Test
    void testPut() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");
        when(this.carRepository.save((Car) any())).thenReturn(car);

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertSame(car1, this.personServiceImpl.put(car1));
        verify(this.carRepository).save((Car) any());
        assertEquals(0L, this.personServiceImpl.getCarCount().longValue());
        assertEquals(0L, this.personServiceImpl.getPersonCount().longValue());
    }

    @Test
    void testPut2() {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());
        when(this.personRepository.save((Person) any())).thenReturn(person);

        Person person1 = new Person();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setBirthdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId(123L);
        person1.setName("Name");
        person1.setCars(new ArrayList<Car>());
        assertSame(person1, this.personServiceImpl.put(person1));
        verify(this.personRepository).save((Person) any());
        assertEquals(0L, this.personServiceImpl.getCarCount().longValue());
        assertEquals(0L, this.personServiceImpl.getPersonCount().longValue());
    }

    @Test
    void testDelete() {
        doNothing().when(this.personRepository).deleteAll();
        this.personServiceImpl.delete();
        verify(this.personRepository).deleteAll();
        assertEquals(0L, this.personServiceImpl.getCarCount().longValue());
        assertEquals(0L, this.personServiceImpl.getPersonCount().longValue());
    }

    @Test
    void testFindById() {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());
        Optional<Person> ofResult = Optional.<Person>of(person);
        when(this.personRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Person> actualFindByIdResult = this.personServiceImpl.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.personRepository).findById((Long) any());
        assertEquals(0L, this.personServiceImpl.getCarCount().longValue());
        assertEquals(0L, this.personServiceImpl.getPersonCount().longValue());
    }

    @Test
    void testGetPersonCount() {
        when(this.personRepository.count()).thenReturn(3L);
        assertEquals(3L, this.personServiceImpl.getPersonCount().longValue());
        verify(this.personRepository).count();
        assertEquals(0L, this.personServiceImpl.getCarCount().longValue());
    }

    @Test
    void testGetCarCount() {
        when(this.carRepository.count()).thenReturn(3L);
        assertEquals(3L, this.personServiceImpl.getCarCount().longValue());
        verify(this.carRepository).count();
        assertEquals(0L, this.personServiceImpl.getPersonCount().longValue());
        assertEquals(0L, this.personServiceImpl.getVendorCount().longValue());
    }

    @Test
    void testGetVendorCount() {
        when(this.carRepository.findAll()).thenReturn(new ArrayList<Car>());
        assertEquals(0L, this.personServiceImpl.getVendorCount().longValue());
        verify(this.carRepository).findAll();
        assertEquals(0L, this.personServiceImpl.getCarCount().longValue());
        assertEquals(0L, this.personServiceImpl.getPersonCount().longValue());
    }

    @Test
    void testGetVendorCount2() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(0L);
        car.setHorsepower(0);
        car.setVendor("Vendor");

        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(car);
        when(this.carRepository.findAll()).thenReturn(carList);
        assertEquals(1L, this.personServiceImpl.getVendorCount().longValue());
        verify(this.carRepository).findAll();
        assertEquals(0L, this.personServiceImpl.getCarCount().longValue());
        assertEquals(0L, this.personServiceImpl.getPersonCount().longValue());
    }

    @Test
    void testGetVendorCount3() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(0L);
        car.setHorsepower(0);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(0L);
        car1.setHorsepower(0);
        car1.setVendor("Vendor");

        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(car1);
        carList.add(car);
        when(this.carRepository.findAll()).thenReturn(carList);
        assertEquals(1L, this.personServiceImpl.getVendorCount().longValue());
        verify(this.carRepository).findAll();
        assertEquals(0L, this.personServiceImpl.getCarCount().longValue());
        assertEquals(0L, this.personServiceImpl.getPersonCount().longValue());
    }

    @Test
    void testFindCarById() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");
        Optional<Car> ofResult = Optional.<Car>of(car);
        when(this.carRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Car> actualFindCarByIdResult = this.personServiceImpl.findCarById(123L);
        assertSame(ofResult, actualFindCarByIdResult);
        assertTrue(actualFindCarByIdResult.isPresent());
        verify(this.carRepository).findById((Long) any());
        assertEquals(0L, this.personServiceImpl.getCarCount().longValue());
        assertEquals(0L, this.personServiceImpl.getPersonCount().longValue());
    }
}

