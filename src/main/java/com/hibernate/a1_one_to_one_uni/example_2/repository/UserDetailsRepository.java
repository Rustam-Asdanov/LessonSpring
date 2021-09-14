package com.hibernate.a1_one_to_one_uni.example_2.repository;

import com.hibernate.a1_one_to_one_uni.example_2.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {
}
