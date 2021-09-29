package com.example.cars.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class PersonTest {
    @Test
    void testCanEqual() {
        assertFalse((new Person()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        Person person = new Person();

        Person person1 = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId(123L);
        person1.setName("Name");
        person1.setCars(new ArrayList<Car>());
        assertTrue(person.canEqual(person1));
    }

    @Test
    void testConstructor() {
        Person actualPerson = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualPerson.setBirthdate(fromResult);
        ArrayList<Car> carList = new ArrayList<Car>();
        actualPerson.setCars(carList);
        actualPerson.setId(123L);
        actualPerson.setName("Name");
        assertSame(fromResult, actualPerson.getBirthdate());
        assertSame(carList, actualPerson.getCars());
        assertEquals(123L, actualPerson.getId().longValue());
        assertEquals("Name", actualPerson.getName());
    }

    @Test
    void testEquals() {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());
        assertFalse(person.equals(null));
    }

    @Test
    void testEquals10() {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName("com.example.cars.model.Person");
        person.setCars(new ArrayList<Car>());

        Person person1 = new Person();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setBirthdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId(123L);
        person1.setName("Name");
        person1.setCars(new ArrayList<Car>());
        assertFalse(person.equals(person1));
    }

    @Test
    void testEquals11() {
        Car car = new Car();
        car.setModel("Name");
        car.setId(123L);
        car.setPerson_id(0L);
        car.setHorsepower(0);
        car.setVendor("Name");

        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(car);

        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName("Name");
        person.setCars(carList);

        Person person1 = new Person();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setBirthdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId(123L);
        person1.setName("Name");
        person1.setCars(new ArrayList<Car>());
        assertFalse(person.equals(person1));
    }

    @Test
    void testEquals12() {
        Person person = new Person();
        person.setBirthdate(null);
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());

        Person person1 = new Person();
        person1.setBirthdate(null);
        person1.setId(123L);
        person1.setName("Name");
        person1.setCars(new ArrayList<Car>());
        assertTrue(person.equals(person1));
        int expectedHashCodeResult = person.hashCode();
        assertEquals(expectedHashCodeResult, person1.hashCode());
    }

    @Test
    void testEquals13() {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(null);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());

        Person person1 = new Person();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setBirthdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId(null);
        person1.setName("Name");
        person1.setCars(new ArrayList<Car>());
        assertTrue(person.equals(person1));
        int expectedHashCodeResult = person.hashCode();
        assertEquals(expectedHashCodeResult, person1.hashCode());
    }

    @Test
    void testEquals2() {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());
        assertFalse(person.equals("Different type to Person"));
    }

    @Test
    void testEquals3() {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());
        assertTrue(person.equals(person));
        int expectedHashCodeResult = person.hashCode();
        assertEquals(expectedHashCodeResult, person.hashCode());
    }

    @Test
    void testEquals4() {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());

        Person person1 = new Person();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setBirthdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId(123L);
        person1.setName("Name");
        person1.setCars(new ArrayList<Car>());
        assertTrue(person.equals(person1));
        int expectedHashCodeResult = person.hashCode();
        assertEquals(expectedHashCodeResult, person1.hashCode());
    }

    @Test
    void testEquals5() {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(0, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());

        Person person1 = new Person();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setBirthdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId(123L);
        person1.setName("Name");
        person1.setCars(new ArrayList<Car>());
        assertFalse(person.equals(person1));
    }

    @Test
    void testEquals6() {
        Person person = new Person();
        person.setBirthdate(null);
        person.setId(123L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());

        Person person1 = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId(123L);
        person1.setName("Name");
        person1.setCars(new ArrayList<Car>());
        assertFalse(person.equals(person1));
    }

    @Test
    void testEquals7() {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(0L);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());

        Person person1 = new Person();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setBirthdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId(123L);
        person1.setName("Name");
        person1.setCars(new ArrayList<Car>());
        assertFalse(person.equals(person1));
    }

    @Test
    void testEquals8() {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(null);
        person.setName("Name");
        person.setCars(new ArrayList<Car>());

        Person person1 = new Person();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setBirthdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId(123L);
        person1.setName("Name");
        person1.setCars(new ArrayList<Car>());
        assertFalse(person.equals(person1));
    }

    @Test
    void testEquals9() {
        Person person = new Person();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setBirthdate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId(123L);
        person.setName(null);
        person.setCars(new ArrayList<Car>());

        Person person1 = new Person();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setBirthdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId(123L);
        person1.setName("Name");
        person1.setCars(new ArrayList<Car>());
        assertFalse(person.equals(person1));
    }
}

