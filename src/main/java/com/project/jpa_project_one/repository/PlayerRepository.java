package com.project.jpa_project_one.repository;

import com.project.jpa_project_one.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
}
