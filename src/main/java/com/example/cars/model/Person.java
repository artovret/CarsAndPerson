package com.example.cars.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "persons")
@Data
public class Person {

    @Id
    //@Column(unique = true,nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthdate")
    private Date birthdate;

    @OneToMany(mappedBy = "person_id", cascade = CascadeType.ALL)
//    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Car> cars;
}


