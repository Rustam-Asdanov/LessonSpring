package com.hibernate.relationship_in_view.repository;

import com.hibernate.relationship_in_view.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher getTeacherById(int id);
}
