package com.example.personservice.controller;

import com.example.personservice.dao.PersonRepository;
import com.example.personservice.model.entity.Person;
import com.example.personservice.util.PersonGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ps-api/person")
@RequiredArgsConstructor
@Slf4j
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        log.info("Get person by id " + id);
        return personRepository.findById(id).get();
    }

    @GetMapping()
    public List<Person> getPersonById() {
        log.info("Get people list");
        return personRepository.findAll();
    }

    @GetMapping("/generate")
    public String generatePeople() {
        personRepository.saveAll(PersonGenerator.generatePeople());
        return "Generated";
    }
}
