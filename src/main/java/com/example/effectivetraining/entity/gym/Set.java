package com.example.effectivetraining.entity.gym;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "train_set")
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer setNum;
    private Float setWeight;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "day_id")
    private Day day;

}
