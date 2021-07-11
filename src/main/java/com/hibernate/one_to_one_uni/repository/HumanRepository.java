package com.hibernate.one_to_one_uni.repository;

import com.hibernate.one_to_one_uni.models.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends JpaRepository<Human,Integer> {
}
