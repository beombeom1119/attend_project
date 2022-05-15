package com.example.attend.service;


import com.example.attend.dto.PersonDto;
import com.example.attend.entity.Person;
import com.example.attend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;


    public List<Person> getAll()
    {
        return (List<Person>) personRepository.findAll();
    }

    public Person get(Long id)
    {
        return personRepository.findById(id).orElse(null);
    }

    public Person Add(PersonDto personDto)
    {
        Person target = personDto.toEntity();
        personRepository.save(target);
        return personRepository.save(target);
    }


    public Person udpate(PersonDto personDto, Long id) {

        Person target = personRepository.findById(id).orElse(null);
        Person updatetarget = personDto.toEntity();
        target.patch(updatetarget);
        personRepository.save(target);
        return personRepository.save(target);
    }


    public Person attend(PersonDto personDto) {
        
    }

}
