package com.crm.testmicroservice2.controllers;

import com.crm.testmicroservice2.services.MessageProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MessageProducerController {

    private final MessageProducerService messageProducerService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/send")
    public Map<String, String> sendMessage(@RequestBody String message) {
        return messageProducerService.messageProducer(message).getBody();
    }

    @GetMapping("/say")
    public String getMethodName() {
        return "Hi, I am from Microservice " + serverPort;
    }
}
