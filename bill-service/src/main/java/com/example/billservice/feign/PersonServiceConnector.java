package com.example.billservice.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "person-service", fallbackFactory = PersonServiceConnector.PersonServiceConnectorFallbackFactory.class)
public interface PersonServiceConnector {
    @GetMapping("/ps-api/person")
    List<Person> getPeople();
    @Component
    class PersonServiceConnectorFallbackFactory implements FallbackFactory<FallbackWithFactory> {
        @Override
        public FallbackWithFactory create(Throwable cause) {
            return new FallbackWithFactory(cause.getMessage());
        }
    }
    @Slf4j
    record FallbackWithFactory(String reason) implements PersonServiceConnector {
        @Override
        public List<Person> getPeople() {
            log.info("Failed send request on person service, reason {}", reason);
            return Collections.emptyList();
        }
    }
}

