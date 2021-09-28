package com.example.cars.repository;

import com.example.cars.model.Message;
import com.example.cars.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
