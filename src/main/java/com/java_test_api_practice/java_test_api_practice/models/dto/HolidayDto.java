package com.java_test_api_practice.java_test_api_practice.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayDto {
    private String name;
    private String name_local;
    private String language;
    private String description;
    private String country;
    private String location;
    private String type;
    private LocalDate date;
    private int date_year;
    private int date_month;
    private int date_day;
    private String week_day;
}
