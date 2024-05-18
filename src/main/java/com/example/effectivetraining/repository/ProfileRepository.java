package com.example.effectivetraining.repository;

import com.example.effectivetraining.entity.user.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Details, Integer> {

    @Query(value = "select d from Details d where d.user = (select u from User u where u.id = :id)")
    Details findByUId(Integer id);

}
