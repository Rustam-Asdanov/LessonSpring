package com.hibernate.a5_eager_vs_lazy.uni.example_1.repository;

import com.hibernate.a5_eager_vs_lazy.uni.example_1.controller.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepository extends JpaRepository<Players, Integer> {
}
