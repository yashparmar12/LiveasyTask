package com.task.demo.Dao;

import com.task.demo.Entities.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoadDao extends JpaRepository<Load, Long> {
    List<Load> findByShipperId(UUID shipperId);
}
