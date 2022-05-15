package com.example.attend.service;


import com.example.attend.dto.PersonDto;
import com.example.attend.entity.Person;
import com.example.attend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;


    // 모든 정보를 가져오는 getALL 함수
    public List<Person> getAll()
    {
        return (List<Person>) personRepository.findAll();
    }

    // 한 명의 정보를 가져오는 get 함수
    public Person get(Long id)
    {
        return personRepository.findById(id).orElse(null);
    }

    // 인원 한 명을 추가하는 Add 함수
    public Person Add(PersonDto personDto)
    {
        Person target = personDto.toEntity();
        personRepository.save(target);
        return personRepository.save(target);
    }

    // 인원 한 명을 수정하는 update 함수
    public Person udpate(PersonDto personDto, Long id) {

        Person target = personRepository.findById(id).orElse(null);
        Person updatetarget = personDto.toEntity();
        target.patch(updatetarget);
        personRepository.save(target);
        return personRepository.save(target);
    }


    // 인원 한 명의 출석 시간을 계산하는 attend 함수
    public Person attend(Long id) {
        Person target = personRepository.findById(id).orElse(null);
        // 출근 시간과 퇴근 시간을 계산하는 부분 Duration 객체를 생성하여 문제 해결
        Duration todayTime = Duration.between(target.getStartTime(),target.getLeaveTime());
        target.setLeaveTime(LocalDateTime.now());
        target.setTodayTime(todayTime.getSeconds());
        personRepository.save(target);
        return personRepository.save(target);
    }



}
