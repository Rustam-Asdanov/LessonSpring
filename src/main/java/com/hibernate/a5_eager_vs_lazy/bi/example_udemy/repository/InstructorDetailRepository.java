package com.hibernate.a5_eager_vs_lazy.bi.example_udemy.repository;

import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.model.InstructorDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends CrudRepository<InstructorDetail,Integer> {
}
