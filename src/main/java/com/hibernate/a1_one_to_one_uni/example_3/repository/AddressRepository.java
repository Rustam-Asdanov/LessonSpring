package com.hibernate.a1_one_to_one_uni.example_3.repository;

import com.hibernate.a1_one_to_one_uni.example_3.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
