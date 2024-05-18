package com.example.effectivetraining.repository;

import com.example.effectivetraining.entity.gym.Youtube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface YoutubeRepository extends JpaRepository<Youtube, Long> {

//    @Query(value = "select y from Youtube y where y.group = (select g from Group g where g.id = :id) and y.exLink = :link")
    @Query(nativeQuery = false
            , value = "select y from Youtube y join y.group g where g.id = :id and y.exLink = :link")
//            , value = "select y from Youtube y where y.group in (select g from Group g where g.id = :id)")
    List<Youtube> findByGroupIdAndLink(Long id, String link);

    List<Youtube> findAllByGroupIdAndExLink(Long id, String link);

}
