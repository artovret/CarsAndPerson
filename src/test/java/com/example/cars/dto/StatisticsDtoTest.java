package com.example.cars.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StatisticsDtoTest {
    @Test
    void testGetStatisticsDto() {
        StatisticsDto actualStatisticsDto = StatisticsDto.getStatisticsDto(3L, 3L, 3L);
        assertEquals(3L, actualStatisticsDto.getCarcount().longValue());
        assertEquals(3L, actualStatisticsDto.getUniquevendorcount().longValue());
        assertEquals(3L, actualStatisticsDto.getPersoncount().longValue());
    }
}

