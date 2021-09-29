package com.example.cars.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class AgeCalculator {
    public static int calculateAge(Date birthDate) {
        if (birthDate != null) {
            return Period.between(birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }
}
