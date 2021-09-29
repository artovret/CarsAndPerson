package com.example.cars.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.cars.exceptions.ValidateException;
import com.example.cars.model.Car;
import com.example.cars.model.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class PersonDtoTest {
    @Test
    void testFromPerson() {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        person.setBirthdate(fromResult);
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());
        PersonDto actualFromPersonResult = PersonDto.fromPerson(person);
        assertSame(fromResult, actualFromPersonResult.getBirthdate());
        assertEquals(123L, actualFromPersonResult.getId().longValue());
        assertEquals("Name", actualFromPersonResult.getName());
    }

    @Test
    void testToPerson() throws ValidateException {
        PersonDto personDto = new PersonDto();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        personDto.setBirthdate(fromResult);
        personDto.setId(123L);
        personDto.setName("Name");
        Person actualToPersonResult = PersonDto.toPerson(personDto);
        assertSame(fromResult, actualToPersonResult.getBirthdate());
        assertEquals("Name", actualToPersonResult.getName());
        assertEquals(123L, actualToPersonResult.getId().longValue());
    }

    @Test
    void testToPerson2() throws ValidateException {
        PersonDto personDto = new PersonDto();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personDto.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personDto.setId(null);
        personDto.setName("Name");
        assertThrows(ValidateException.class, () -> PersonDto.toPerson(personDto));
    }

    @Test
    void testToPerson3() throws ValidateException {
        PersonDto personDto = new PersonDto();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personDto.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personDto.setId(123L);
        personDto.setName(null);
        assertThrows(ValidateException.class, () -> PersonDto.toPerson(personDto));
    }
}

