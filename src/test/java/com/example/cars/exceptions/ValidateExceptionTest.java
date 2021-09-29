package com.example.cars.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ValidateExceptionTest {
    @Test
    void testConstructor() {
        ValidateException actualValidateException = new ValidateException("An error occurred");
        assertNull(actualValidateException.getCause());
        assertEquals("com.example.cars.exceptions.ValidateException: An error occurred",
                actualValidateException.toString());
        assertEquals(0, actualValidateException.getSuppressed().length);
        assertEquals("An error occurred", actualValidateException.getMessage());
        assertEquals("An error occurred", actualValidateException.getLocalizedMessage());
    }
}

