package com.hibernate.a3_one_to_many.bi.example_1.repository;

import com.hibernate.a3_one_to_many.bi.example_1.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
}
