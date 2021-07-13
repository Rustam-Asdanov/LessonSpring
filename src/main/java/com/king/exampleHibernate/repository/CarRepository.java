package com.king.exampleHibernate.repository;

import com.king.exampleHibernate.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
