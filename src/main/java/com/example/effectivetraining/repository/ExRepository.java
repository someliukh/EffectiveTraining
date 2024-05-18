package com.example.effectivetraining.repository;

import com.example.effectivetraining.entity.gym.Exercise;
import com.example.effectivetraining.entity.gym.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExRepository extends JpaRepository<Exercise, Long> {

    Exercise findByExerciseName(String name);

}
