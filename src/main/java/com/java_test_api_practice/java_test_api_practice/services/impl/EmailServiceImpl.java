package com.java_test_api_practice.java_test_api_practice.services.impl;

import com.java_test_api_practice.java_test_api_practice.services.interfaces.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to, String subject, String message) {
        System.out.println("Send email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);


        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("enterprise@email.com");

        try {
            javaMailSender.send(mailMessage);
            System.out.println("Send email to: " + to);
            System.out.println("Subject: " + subject);
            System.out.println("Message: " + message);
        } catch (Exception e) {
            System.err.println("Error to send email: " + e.getMessage());
        }
    }
}
