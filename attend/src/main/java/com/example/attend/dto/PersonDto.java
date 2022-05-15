package com.example.attend.dto;

import com.example.attend.entity.Person;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private Long id;

    private String name;

    private String part;

    private LocalDateTime start;

    private LocalDateTime leave;

    private LocalDateTime todayTime;

    public Person toEntity() {

        return new Person(id,name,part,start,leave,todayTime);

    }
}
