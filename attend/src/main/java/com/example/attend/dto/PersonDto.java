package com.example.attend.dto;

import com.example.attend.entity.Person;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonDto {

    private Long id;

    private String name;

    private String part;

    private LocalDateTime startTime;

    private LocalDateTime leaveTime;

    private Long todayTime;

    public Person toEntity() {

        return new Person(id,name,part,startTime,leaveTime,todayTime);

    }
}
