package com.java_test_api_practice.java_test_api_practice.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 50, message = "You must insert any name.")
    private String username;

    @Size(min = 2, max = 50, message = "You must insert any lastname.")
    private String lastname;

    @Email(message = "Email must be valid.")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "You must insert a birthday!")
    private LocalDate birthday;

    @NotBlank(message = "You must insert a start date!")
    private LocalDate startDay;

    @NotBlank(message = "You must insert is active or not!")
    private Boolean active;
}
