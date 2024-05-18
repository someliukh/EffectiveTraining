package com.example.effectivetraining.repository;

import com.example.effectivetraining.entity.gym.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findGroupByGroupName(String name);

    //    @Query(value = "select g from Group g where g.exercises = (select e from Exercise e where e.id = :id)")
    @Query(value = "select g from Group g join g.exercises e where e.id = :id")
    Group findGroupByExercisesId(Integer id);

}
