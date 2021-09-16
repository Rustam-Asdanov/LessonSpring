package com.hibernate.a3_one_to_many.bi.example_udemy.repository;

import com.hibernate.a3_one_to_many.bi.example_udemy.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
