package com.hibernate.a4_many_to_many.uni.example_2.repository;

import com.hibernate.a4_many_to_many.uni.example_2.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
}
