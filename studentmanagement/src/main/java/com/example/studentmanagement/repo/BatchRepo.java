package com.example.studentmanagement.repo;

import com.example.studentmanagement.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepo extends JpaRepository<Batch,Integer> {
}
