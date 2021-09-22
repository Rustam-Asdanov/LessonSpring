package com.hibernate.a5_eager_vs_lazy.bi.example_1.repository;

import com.hibernate.a5_eager_vs_lazy.bi.example_1.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
}
