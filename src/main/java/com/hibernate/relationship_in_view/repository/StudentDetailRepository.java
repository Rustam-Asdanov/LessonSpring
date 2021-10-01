package com.hibernate.relationship_in_view.repository;


import com.hibernate.relationship_in_view.model.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailRepository extends JpaRepository<StudentDetail,Integer> {
}
