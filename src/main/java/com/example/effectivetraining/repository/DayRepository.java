package com.example.effectivetraining.repository;

import com.example.effectivetraining.entity.gym.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

    List<Day> findAllByUserId(Integer id);

    @Query(value = "select d from Day d where d.date = :date and d.user.id = :id")
    Day findByDate(LocalDate date, Integer id);

}
