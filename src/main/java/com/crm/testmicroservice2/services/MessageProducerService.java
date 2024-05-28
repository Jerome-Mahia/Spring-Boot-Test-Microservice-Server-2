package com.crm.testmicroservice2.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageProducerService {
    static String QUEUE_NAME = "q.test-queue";
    private final RabbitTemplate rabbitTemplate;

    public ResponseEntity<Map<String, String>> messageProducer(String message) {
        try {
            Map<String, String> response = new HashMap<>();
            rabbitTemplate.convertAndSend("", QUEUE_NAME, message);
            response.put("status", "success");
            response.put("message", "Message sent to queue successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error occurred while producing message", e);
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
