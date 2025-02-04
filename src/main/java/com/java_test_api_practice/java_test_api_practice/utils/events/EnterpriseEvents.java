package com.java_test_api_practice.java_test_api_practice.utils.events;

import com.java_test_api_practice.java_test_api_practice.models.entities.Employee;
import com.java_test_api_practice.java_test_api_practice.utils.response.EventResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnterpriseEvents {
    public static Optional<EventResponse> calculateEvents(Employee employee, LocalDate today, LocalDate endDate) {
        LocalDate birthdayThisYear = employee.getBirthday().withYear(today.getYear());
        LocalDate workAnniversary = employee.getStartDay().withYear(today.getYear());

        if (birthdayThisYear.isBefore(today)) {
            birthdayThisYear = birthdayThisYear.plusYears(1);
        }
        if (workAnniversary.isBefore(today)) {
            workAnniversary = workAnniversary.plusYears(1);
        }

        List<String> events = new ArrayList<>();
        if (!birthdayThisYear.isAfter(endDate)) {
            int age = today.getYear() - employee.getBirthday().getYear();
            events.add("Turns  " + age + " on " + birthdayThisYear);
        }
        if (!workAnniversary.isAfter(endDate)) {
            int yearsWorked = today.getYear() - employee.getStartDay().getYear();
            events.add(yearsWorked + "Year work anniversary on " + workAnniversary);
        }

        return events.isEmpty() ? Optional.empty() : Optional.of(new EventResponse(employee.getId(), employee.getUsername(), events));
    }
}
