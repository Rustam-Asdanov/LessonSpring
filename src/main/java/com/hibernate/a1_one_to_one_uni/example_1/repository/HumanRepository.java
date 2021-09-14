package com.hibernate.a1_one_to_one_uni.example_1.repository;

import com.hibernate.a1_one_to_one_uni.example_1.models.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends JpaRepository<Human,Integer> {
}
