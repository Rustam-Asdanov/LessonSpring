package com.hibernate.relationship_in_view.repository;

import com.hibernate.relationship_in_view.model.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonsRepository extends JpaRepository<Lessons,Integer> {
    Lessons getLessonsById(int id);

    Lessons getLessonsByTopic(String topic);
}
