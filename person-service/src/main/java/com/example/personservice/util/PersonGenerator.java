package com.example.personservice.util;

import com.example.personservice.model.entity.Person;

import java.util.List;

public class PersonGenerator {

    public static List<Person> generatePeople() {
        Person person1 = Person.builder().name("Ivan Ivanov").age(33).weight(78).build();
        Person person2 = Person.builder().name("Oleg Olegov").age(24).weight(89).build();
        Person person3 = Person.builder().name("Petr Petrov").age(64).weight(88).build();
        Person person4 = Person.builder().name("Sergey Sergeev").age(43).weight(92).build();
        Person person5 = Person.builder().name("Irina Irinovna").age(22).weight(65).build();
        return List.of(person1, person2, person3, person4, person5);
    }
}
