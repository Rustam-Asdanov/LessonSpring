package com.hibernate.a3_one_to_many.uni.example_2.repository;

import com.hibernate.a3_one_to_many.uni.example_2.model.Student;
import com.hibernate.a3_one_to_many.uni.example_2.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
}
