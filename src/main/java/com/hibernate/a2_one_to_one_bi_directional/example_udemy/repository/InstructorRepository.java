package com.hibernate.a2_one_to_one_bi_directional.example_udemy.repository;

import com.hibernate.a2_one_to_one_bi_directional.example_udemy.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
