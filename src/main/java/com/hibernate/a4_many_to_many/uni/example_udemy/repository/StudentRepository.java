package com.hibernate.a4_many_to_many.uni.example_udemy.repository;

import com.hibernate.a4_many_to_many.uni.example_udemy.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
