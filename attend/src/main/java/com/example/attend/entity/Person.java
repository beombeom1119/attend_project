package com.example.attend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String part;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime leaveTime;

    @Column
    private Long todayTime;


    public void patch(Person person) {
        if (person.name!=null)
        {
            this.name = person.name;
        }
        if (person.part!=null)
        {
            this.part = person.part;
        }
        if (person.startTime!=null)
        {
            this.startTime = person.startTime;
        }
        if (person.leaveTime!=null)
        {
            this.leaveTime = person.leaveTime;
        }
        if (person.todayTime!=null)
        {
            this.todayTime = person.todayTime;
        }


    }

}
