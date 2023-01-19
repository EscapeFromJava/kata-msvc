package com.example.personservice.controller;

import com.example.personservice.dao.PersonRepository;
import com.example.personservice.model.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ps-api")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/person/{id}")
    public Person getPeople(@PathVariable Long id) {
        return personRepository.findById(id).get();
    }

    @GetMapping("/person")
    public List<Person> getPeople() {
        return personRepository.findAll();
    }
}
