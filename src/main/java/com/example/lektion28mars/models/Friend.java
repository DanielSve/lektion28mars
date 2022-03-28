package com.example.lektion28mars.models;



import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Friend {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;


}
