package com.hibernate.a4_many_to_many.uni.example_udemy.repository;

import com.hibernate.a4_many_to_many.uni.example_udemy.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
}
