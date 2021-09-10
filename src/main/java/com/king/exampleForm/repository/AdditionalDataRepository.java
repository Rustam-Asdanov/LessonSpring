package com.king.exampleForm.repository;

import com.king.exampleForm.model.AdditionalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalDataRepository extends JpaRepository<AdditionalData,Long> {
}
