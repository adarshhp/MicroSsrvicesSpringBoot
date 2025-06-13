package com.example.demo.repository;

import com.example.demo.model.MangoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangoRepository extends JpaRepository<MangoModel, Long> {
}
