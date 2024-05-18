package com.example.effectivetraining.repository;

import com.example.effectivetraining.entity.gym.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetRepository extends JpaRepository<Set, Long> {
}
