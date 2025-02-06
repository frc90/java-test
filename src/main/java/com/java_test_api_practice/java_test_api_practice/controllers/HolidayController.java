package com.java_test_api_practice.java_test_api_practice.controllers;

import com.java_test_api_practice.java_test_api_practice.services.impl.HolidayServiceImpl;
import com.java_test_api_practice.java_test_api_practice.utils.response.ApiResponse;
import com.java_test_api_practice.java_test_api_practice.utils.response.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api")
public class HolidayController {

    @Autowired
    private HolidayServiceImpl holidayServiceImpl;

    @GetMapping("/holidays")
    public ResponseEntity<ApiResponse<List<LocalDate>>> getHolidays(HttpServletRequest request) {
        List<LocalDate> localDateList = holidayServiceImpl.getUpcomingHolidays();
        return ResponseEntity.ok(ResponseUtil.success(localDateList, "Holidays!", request.getRequestURI()));
    }
}
