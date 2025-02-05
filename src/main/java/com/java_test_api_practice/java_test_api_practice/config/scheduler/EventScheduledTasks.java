package com.java_test_api_practice.java_test_api_practice.config.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EventScheduledTasks {

    @Scheduled(cron = "0 0 6 * * ?")
    public void executeTask() {
        System.out.println("Executing task at " + new Date());
    }
}
