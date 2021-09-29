package com.example.cars.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class AgeCalculatorTest {
    @Test
    void testCalculateAge() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        assertEquals(51, AgeCalculator.calculateAge(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
    }

    @Test
    void testCalculateAge2() {
        assertEquals(0, AgeCalculator.calculateAge(null));
    }
}

