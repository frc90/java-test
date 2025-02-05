package com.java_test_api_practice.java_test_api_practice.config.scheduler;

import com.java_test_api_practice.java_test_api_practice.services.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EventScheduledTasks {

    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @Scheduled(cron = "0 0 6 * * ?")
    public void executeTask() {
        System.out.println("Executing task at " + new Date());
        emailServiceImpl.sendEmail(
                "no-reply@example.com",
                "Daily Events",
                "Any message form server!"
        );
    }
}
