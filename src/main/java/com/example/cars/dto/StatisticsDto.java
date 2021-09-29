package com.example.cars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatisticsDto {
    private Long personcount;
    private Long carcount;
    private Long uniquevendorcount;

    public static StatisticsDto getStatisticsDto(Long personCount, Long carCount, Long uniquevendorCount) {
        StatisticsDto statisticsDto = new StatisticsDto();
        statisticsDto.setPersoncount(personCount);
        statisticsDto.setCarcount(carCount);
        statisticsDto.setUniquevendorcount(uniquevendorCount);
        return statisticsDto;
    }
}
