package com.example.cars.rest;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.example.cars.dto.CarDto;
import com.example.cars.dto.PersonDto;
import com.example.cars.model.Car;
import com.example.cars.model.Person;
import com.example.cars.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;

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
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {InputRestController.class})
@ExtendWith(SpringExtension.class)
class InputRestControllerTest {
    @Autowired
    private InputRestController inputRestController;

    @MockBean
    private PersonService personService;

    @Test
    void testAddCar() throws Exception {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");
        Optional<Car> ofResult = Optional.<Car>of(car);
        when(this.personService.findCarById(anyLong())).thenReturn(ofResult);

        CarDto carDto = new CarDto();
        carDto.setModel("Model");
        carDto.setId(123L);
        carDto.setOwnerId(123L);
        carDto.setHorsepower(1);
        String content = (new ObjectMapper()).writeValueAsString(carDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/car")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.inputRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testAddCar2() throws Exception {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());
        Optional<Person> ofResult = Optional.<Person>of(person);
        when(this.personService.findById(anyLong())).thenReturn(ofResult);
        when(this.personService.findCarById(anyLong())).thenReturn(Optional.<Car>empty());

        CarDto carDto = new CarDto();
        carDto.setModel("Model");
        carDto.setId(123L);
        carDto.setOwnerId(123L);
        carDto.setHorsepower(1);
        String content = (new ObjectMapper()).writeValueAsString(carDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/car")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.inputRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testAddCar3() throws Exception {
        Person person = new Person();
        person.setBirthdate(null);
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());
        Optional<Person> ofResult = Optional.<Person>of(person);
        when(this.personService.findById(anyLong())).thenReturn(ofResult);
        when(this.personService.findCarById(anyLong())).thenReturn(Optional.<Car>empty());

        CarDto carDto = new CarDto();
        carDto.setModel("Model");
        carDto.setId(123L);
        carDto.setOwnerId(123L);
        carDto.setHorsepower(1);
        String content = (new ObjectMapper()).writeValueAsString(carDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/car")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.inputRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testAddCar4() throws Exception {
        Car car = new Car();
        car.setModel("?");
        car.setId(123L);
        car.setPerson_id(0L);
        car.setHorsepower(0);
        car.setVendor("?");
        Optional<Car> ofResult = Optional.<Car>of(car);
        when(this.personService.findById(anyLong())).thenReturn(Optional.<Person>empty());
        when(this.personService.findCarById(anyLong())).thenReturn(ofResult);

        CarDto carDto = new CarDto();
        carDto.setModel("Model");
        carDto.setId(123L);
        carDto.setOwnerId(123L);
        carDto.setHorsepower(1);
        String content = (new ObjectMapper()).writeValueAsString(carDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/car")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.inputRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testAddCar5() throws Exception {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());
        Optional<Person> ofResult = Optional.<Person>of(person);

        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");
        when(this.personService.put((Car) any())).thenReturn(car);
        when(this.personService.findById(anyLong())).thenReturn(ofResult);
        when(this.personService.findCarById(anyLong())).thenReturn(Optional.<Car>empty());

        CarDto carDto = new CarDto();
        carDto.setModel("-");
        carDto.setId(123L);
        carDto.setOwnerId(123L);
        carDto.setHorsepower(1);
        String content = (new ObjectMapper()).writeValueAsString(carDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/car")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.inputRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"car\":{\"id\":123,\"vendor\":\"Vendor\",\"model\":\"Model\",\"horsepower\":1,\"person_id\":1}}"));
    }

    @Test
    void testAddPerson() throws Exception {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());
        Optional<Person> ofResult = Optional.<Person>of(person);
        when(this.personService.findById(anyLong())).thenReturn(ofResult);

        PersonDto personDto = new PersonDto();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personDto.setBirthdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personDto.setId(123L);
        personDto.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(personDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.inputRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testAddPerson2() throws Exception {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());
        when(this.personService.put((Person) any())).thenReturn(person);
        when(this.personService.findById(anyLong())).thenReturn(Optional.<Person>empty());

        PersonDto personDto = new PersonDto();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personDto.setBirthdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personDto.setId(123L);
        personDto.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(personDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.inputRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"person\":{\"id\":123,\"name\":\"Name\",\"birthdate\":0,\"cars\":[]}}"));
    }
}

