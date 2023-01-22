package com.example.personservice.listeners;

import com.example.personservice.dao.MessagesRepository;
import com.example.personservice.model.entity.CustomMessage;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@EnableKafka
@RequiredArgsConstructor
public class CustomListener {

    private final MessagesRepository messagesRepository;

    @KafkaListener(topics = {"admin"})
    public void listenToAdmin(ConsumerRecord<String, String> message) {
        CustomMessage customMessage = new CustomMessage(message.topic(), message.value());
        messagesRepository.save(customMessage);

        System.out.println("Topic: " + message.topic() + "\n" +
                "Date: " + message.timestamp());
    }

    @KafkaListener(topics = {"operator"})
    public void listenToOperator(ConsumerRecord<String, String> message) {
        CustomMessage customMessage = new CustomMessage(message.topic(), message.value());
        messagesRepository.save(customMessage);

        System.out.println("CustomMessage: " + message.value());
    }

    @KafkaListener(topics = {"system"})
    public void listenToSystem(ConsumerRecord<String, String> message) {
        CustomMessage customMessage = new CustomMessage(message.topic(), message.value());
        messagesRepository.save(customMessage);

        String sb = "Topic: " + message.topic() + "\n" +
                "Partition: " + message.partition() + "\n" +
                "Offset: " + message.offset() + "\n" +
                "Date: " + message.timestamp() + "\n" +
                "CustomMessage: " + message.value() + "\n";
        System.out.println(sb);
    }

}
