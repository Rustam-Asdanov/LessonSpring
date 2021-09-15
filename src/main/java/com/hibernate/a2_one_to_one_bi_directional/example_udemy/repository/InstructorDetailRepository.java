package com.hibernate.a2_one_to_one_bi_directional.example_udemy.repository;

import com.hibernate.a2_one_to_one_bi_directional.example_udemy.model.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {
}
