package com.example.sender.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "kafka_sent_messages")
@Data
public class SentMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private String response;
    private LocalDateTime sentAt = LocalDateTime.now();
}
