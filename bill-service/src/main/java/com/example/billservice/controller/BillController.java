package com.example.billservice.controller;

import com.example.billservice.feign.Person;
import com.example.billservice.feign.PersonServiceConnector;
import com.example.billservice.model.Bill;
import com.example.billservice.model.parse.Container;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/bs-api")
@RequiredArgsConstructor
public class BillController {

    private final PersonServiceConnector personServiceConnector;

    @GetMapping("/bill/{personId}")
    public Bill getBillByPersonId(@PathVariable Long personId) {
        List<Person> people = personServiceConnector.getPeople();
        Person currentPerson = people.stream().filter(p -> p.getId() == personId).findFirst().get();
        return new Bill(15, currentPerson.getName(), 1000);
    }

    @GetMapping("/out/{currency}")
    public Container getDollarRate(@Value("${token}") String token, @PathVariable String currency) {

        String urlTemplate = UriComponentsBuilder.fromHttpUrl("https://api.freecurrencyapi.com/v1/currencies")
                .queryParam("apikey", token)
                .queryParam("currencies", currency)
                .encode()
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(urlTemplate, Container.class);
    }
}
