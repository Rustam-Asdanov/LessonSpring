package com.hibernate.a3_one_to_many.repository;

import com.hibernate.a3_one_to_many.controller.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepository extends JpaRepository<Players, Integer> {
}
