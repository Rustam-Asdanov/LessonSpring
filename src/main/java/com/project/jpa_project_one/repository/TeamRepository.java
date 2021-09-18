package com.project.jpa_project_one.repository;

import com.project.jpa_project_one.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
}
