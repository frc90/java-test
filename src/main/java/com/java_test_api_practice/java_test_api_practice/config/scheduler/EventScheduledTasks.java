package com.java_test_api_practice.java_test_api_practice.config.scheduler;

import com.java_test_api_practice.java_test_api_practice.services.impl.EmailServiceImpl;
import com.java_test_api_practice.java_test_api_practice.services.impl.HolidayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class EventScheduledTasks {

    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @Autowired
    private HolidayServiceImpl holidayServiceImpl;

    @Scheduled(cron = "0 0 6 * * ?")
    public void executeTask() {
        System.out.println("Executing task at " + new Date());
        List<LocalDate> holidays = holidayServiceImpl.getUpcomingHolidays();
        emailServiceImpl.sendEmail(
                "no-reply@example.com",
                "Daily Events",
                "Holidays coming are: " + holidays
        );
    }
}
