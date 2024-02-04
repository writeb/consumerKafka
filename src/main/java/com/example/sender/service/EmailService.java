package com.example.sender.service;

import com.example.sender.model.SentMessage;
import com.example.sender.repository.SentMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SentMessageRepository repository;

    public void sendEmail(String toAddress, String subject, String messageContent) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toAddress);
        message.setSubject(subject);
        message.setText(messageContent);

        String response;
        try {
            emailSender.send(message);
            response = "SUCCESS";
        } catch (Exception e) {
            response = "FAILURE: " + e.getMessage();
        }

        SentMessage sentMessage = new SentMessage();
        sentMessage.setMessage(messageContent);
        sentMessage.setResponse(response);
        repository.save(sentMessage);
    }
}
