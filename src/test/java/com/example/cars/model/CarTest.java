package com.example.cars.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void testCanEqual() {
        assertFalse((new Car()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        Car car = new Car();

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(0L);
        car1.setHorsepower(0);
        car1.setVendor("Vendor");
        assertTrue(car.canEqual(car1));
    }

    @Test
    void testConstructor() {
        Car actualCar = new Car();
        actualCar.setHorsepower(1);
        actualCar.setId(123L);
        actualCar.setModel("Model");
        actualCar.setPerson_id(1L);
        actualCar.setVendor("Vendor");
        assertEquals(1, actualCar.getHorsepower().intValue());
        assertEquals(123L, actualCar.getId().longValue());
        assertEquals("Model", actualCar.getModel());
        assertEquals(1L, actualCar.getPerson_id().longValue());
        assertEquals("Vendor", actualCar.getVendor());
        assertEquals("Car(id=123, vendor=Vendor, model=Model, horsepower=1, person_id=1)", actualCar.toString());
    }

    @Test
    void testEquals() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");
        assertFalse(car.equals(null));
    }

    @Test
    void testEquals10() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(null);
        car.setHorsepower(1);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertFalse(car.equals(car1));
    }

    @Test
    void testEquals11() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(0);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertFalse(car.equals(car1));
    }

    @Test
    void testEquals12() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(null);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertFalse(car.equals(car1));
    }

    @Test
    void testEquals13() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Model");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertFalse(car.equals(car1));
    }

    @Test
    void testEquals14() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor(null);

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertFalse(car.equals(car1));
    }

    @Test
    void testEquals15() {
        Car car = new Car();
        car.setModel(null);
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel(null);
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertTrue(car.equals(car1));
        int expectedHashCodeResult = car.hashCode();
        assertEquals(expectedHashCodeResult, car1.hashCode());
    }

    @Test
    void testEquals16() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(null);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(null);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertTrue(car.equals(car1));
        int expectedHashCodeResult = car.hashCode();
        assertEquals(expectedHashCodeResult, car1.hashCode());
    }

    @Test
    void testEquals17() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(null);
        car.setHorsepower(1);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(null);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertTrue(car.equals(car1));
        int expectedHashCodeResult = car.hashCode();
        assertEquals(expectedHashCodeResult, car1.hashCode());
    }

    @Test
    void testEquals18() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(null);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(null);
        car1.setVendor("Vendor");
        assertTrue(car.equals(car1));
        int expectedHashCodeResult = car.hashCode();
        assertEquals(expectedHashCodeResult, car1.hashCode());
    }

    @Test
    void testEquals2() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");
        assertFalse(car.equals("Different type to Car"));
    }

    @Test
    void testEquals3() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");
        assertTrue(car.equals(car));
        int expectedHashCodeResult = car.hashCode();
        assertEquals(expectedHashCodeResult, car.hashCode());
    }

    @Test
    void testEquals4() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertTrue(car.equals(car1));
        int expectedHashCodeResult = car.hashCode();
        assertEquals(expectedHashCodeResult, car1.hashCode());
    }

    @Test
    void testEquals5() {
        Car car = new Car();
        car.setModel("Vendor");
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertFalse(car.equals(car1));
    }

    @Test
    void testEquals6() {
        Car car = new Car();
        car.setModel(null);
        car.setId(123L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertFalse(car.equals(car1));
    }

    @Test
    void testEquals7() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(0L);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertFalse(car.equals(car1));
    }

    @Test
    void testEquals8() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(null);
        car.setPerson_id(1L);
        car.setHorsepower(1);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertFalse(car.equals(car1));
    }

    @Test
    void testEquals9() {
        Car car = new Car();
        car.setModel("Model");
        car.setId(123L);
        car.setPerson_id(0L);
        car.setHorsepower(1);
        car.setVendor("Vendor");

        Car car1 = new Car();
        car1.setModel("Model");
        car1.setId(123L);
        car1.setPerson_id(1L);
        car1.setHorsepower(1);
        car1.setVendor("Vendor");
        assertFalse(car.equals(car1));
    }
}

