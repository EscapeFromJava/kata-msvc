package com.example.materialsservice.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.List;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    @Value("${broker-port}")
    private int brokerPort;

    @Bean
    public Map<String, Object> getPropertyFromKafka() {
        KafkaProperties properties = new KafkaProperties();
        KafkaProperties.Producer producer = properties.getProducer();
        producer.setBootstrapServers(List.of("localhost:" + brokerPort));
        return producer.buildProperties();
    }

    @Bean
    public ProducerFactory<String, String> getProducerFactory() {
        return new DefaultKafkaProducerFactory<>(getPropertyFromKafka());
    }

    @Bean
    public KafkaTemplate<String, String> getKafka() {
        return new KafkaTemplate<>(getProducerFactory());
    }

}
