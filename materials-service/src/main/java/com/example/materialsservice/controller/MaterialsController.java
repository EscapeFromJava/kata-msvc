package com.example.materialsservice.controller;

import com.example.materialsservice.entity.KafkaMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms-api")
@RequiredArgsConstructor
public class MaterialsController {

    private final KafkaMessage kafkaMessage;

    @PostMapping("/send")
    public String addMaterial(@RequestParam("category") String category,
                              @RequestParam("message") String message) {
        switch (category) {
            case "system" -> {
                kafkaMessage.sendSystemMessage(message);
            }
            case "operator" -> {
                kafkaMessage.sendOperatorMessage(message);
            }
            case "admin" -> {
                kafkaMessage.sendAdminMessage(message);
            }
        }
        return "The message (" + message + ") was sent to the topic " + category;
    }

}
