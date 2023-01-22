package com.example.materialsservice.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaMessage {

    private final KafkaTemplate<String, String> template;

    public void sendSystemMessage(String message) {
        template.send("system", message);
    }

    public void sendOperatorMessage(String message) {
        template.send("operator", message);
    }

    public void sendAdminMessage(String message) {
        template.send("admin", message);
    }

}
