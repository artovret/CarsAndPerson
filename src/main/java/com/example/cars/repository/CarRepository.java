package com.example.cars.repository;

import com.example.cars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("cars")
public interface CarRepository extends JpaRepository<Car, Long> {
}
