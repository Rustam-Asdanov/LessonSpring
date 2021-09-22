package com.hibernate.a5_eager_vs_lazy.uni.example_2.repository;

import com.hibernate.a5_eager_vs_lazy.uni.example_2.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
}
