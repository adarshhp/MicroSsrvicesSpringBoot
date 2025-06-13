package com.example.demo.repository;

import com.example.demo.model.AppleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppleRepository extends JpaRepository<AppleModel, Long> {
}
