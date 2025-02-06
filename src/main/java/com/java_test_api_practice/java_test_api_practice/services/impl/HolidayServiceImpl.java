package com.java_test_api_practice.java_test_api_practice.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.java_test_api_practice.java_test_api_practice.models.dto.HolidayDesDto;
import com.java_test_api_practice.java_test_api_practice.services.interfaces.HolidayService;
import org.springframework.beans.factory.annotation.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService {

    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;
    @Value("${API_URL}")
    private String API_URL;

    @Value("${API_KEY}")
    private String API_KEY;


    String URL = "&country=US&year=%d&month=%d&day=%d";

    public HolidayServiceImpl(ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<LocalDate> getUpcomingHolidays() {
        List<LocalDate> holidays = new ArrayList<>();
        LocalDate today = LocalDate.now();
//        LocalDate today = LocalDate.of(2025, 1, 1); // test days
        LocalDate tomorrow = today.plusDays(1);
        LocalDate dayAfterTomorrow = today.plusDays(2);

        if (isHoliday(today)) holidays.add(today);
        if (isHoliday(tomorrow)) holidays.add(tomorrow);
        if (isHoliday(dayAfterTomorrow)) holidays.add(dayAfterTomorrow);
        return holidays;
    }

    public boolean isHoliday(LocalDate date) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String apiUrl = String.format(API_URL + API_KEY + URL, date.getYear(), date.getMonthValue(), date.getDayOfMonth());
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

            if (response.hasBody() && response.getBody() != null) {
                List<HolidayDesDto> holidays = objectMapper.readValue(
                        response.getBody(),
                        new TypeReference<>() {}
                );
                if (!holidays.isEmpty()) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error to: " + e.getMessage());
        }
        return false;
    }
}
