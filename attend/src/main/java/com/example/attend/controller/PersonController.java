package com.example.attend.controller;


import com.example.attend.dto.PersonDto;
import com.example.attend.entity.Person;
import com.example.attend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/person")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/person/{id}")
    public Person get(@PathVariable Long id) {
        return personService.get(id);
    }

    @PostMapping("/person")
    public Person Add(@RequestBody PersonDto personDto) {
        Person person = personService.Add(personDto);
        return person;
    }

    @PutMapping("/person/{id}")
    public Person Update(@RequestBody PersonDto personDto, @PathVariable Long id) {
        Person target = personService.udpate(personDto, id);
        return target;
    }

    @PostMapping("/person/attend")
    public Person Add(@RequestBody PersonDto personDto) {
        Person person = personService.attend(personDto);

    }




}
