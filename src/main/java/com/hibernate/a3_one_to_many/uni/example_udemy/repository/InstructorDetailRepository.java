package com.hibernate.a3_one_to_many.uni.example_udemy.repository;

import com.hibernate.a3_one_to_many.uni.example_udemy.model.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail,Integer> {
}
