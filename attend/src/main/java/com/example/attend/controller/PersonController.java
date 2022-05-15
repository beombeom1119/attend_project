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

    // 모든 인원의 정보를 불러오는 getAll() 함수 -> URL 주소를 person으로 해야하는지, People로 해야하는지 찾아보기.
    @GetMapping("/person")
    public List<Person> getAll() {
        return personService.getAll();
    }

    // 한 명의 인원을 가져오는 Get 함수
    @GetMapping("/person/{id}")
    public Person get(@PathVariable Long id) {
        return personService.get(id);
    }

    // 인원 생성(add)   -- 추가시 leavetime과 todayTime은 Null로 추가해야한다.
    @PostMapping("/person")
    public Person Add(@RequestBody PersonDto personDto) {
        Person person = personService.Add(personDto);
        return person;
    }

    /// 인원 수정(update)
    @PutMapping("/person/{id}")
    public Person Update(@RequestBody PersonDto personDto, @PathVariable Long id) {
        Person target = personService.udpate(personDto, id);
        return target;
    }

    ///// 출석 (Attend)
    @PutMapping("/attend/{id}")
    public Person Attend(@PathVariable Long id) {
        return personService.attend(id);
    }



}
