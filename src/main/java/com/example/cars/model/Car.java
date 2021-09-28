package com.example.cars.model;


import lombok.Data;

import javax.persistence.*;


//JSON, представляющий объект Car
//        {
//        id: Long (not null),
//        model: String (not null, в формате vendor-model например BMW-X5, причем vendor никогда не содержит “-” и не пустой, model не пустой),
//        horsepower: Integer (not null),
//        ownerId: Long (not null)
//        }

@Entity
@Table(name = "cars")
@Data
public class Car {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "power")
    private Integer horsepower;

    @JoinColumn(name = "person_id", nullable = false)
//    @Column(name = "person_id")
    private Long person_id;
}


