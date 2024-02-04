package com.example.sender.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    private final EmailService emailService;

    @Autowired
    public KafkaMessageListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "message.send", containerFactory = "kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String, String> record) {
        String emailContent = record.value();

        String recipient = "sultanbek20001@mail.ru";
        String subject = "New message from Kafka";

        emailService.sendEmail(recipient, subject, emailContent);
    }
}
