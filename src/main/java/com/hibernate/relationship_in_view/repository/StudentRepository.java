package com.hibernate.relationship_in_view.repository;

import com.hibernate.relationship_in_view.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student getStudentById(int id);
}
