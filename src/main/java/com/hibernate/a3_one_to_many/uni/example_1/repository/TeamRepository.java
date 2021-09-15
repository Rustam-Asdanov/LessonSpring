package com.hibernate.a3_one_to_many.uni.example_1.repository;

import com.hibernate.a3_one_to_many.uni.example_1.controller.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
