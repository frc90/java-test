package com.java_test_api_practice.java_test_api_practice.services.interfaces;

import java.time.LocalDate;
import java.util.List;

public interface HolidayService {
    List<LocalDate> getUpcomingHolidays();
}
