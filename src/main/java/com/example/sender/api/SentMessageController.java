package com.example.sender.api;

import com.example.sender.model.SentMessage;
import com.example.sender.repository.SentMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sent-messages")
public class SentMessageController {

    @Autowired
    private SentMessageRepository sentMessageRepository;

    @GetMapping
    public List<SentMessage> getAllSentMessages() {
        return sentMessageRepository.findAll();
    }
}
