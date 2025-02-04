package com.java_test_api_practice.java_test_api_practice.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EventDateDto {
    @NotNull(message = "You must insert a date")
    private LocalDate startDate;

    @Min(value = 1, message = "The value must be greater than 1")
    private int daysAhead;
}
