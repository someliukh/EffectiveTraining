package com.example.effectivetraining.entity.gym;

import com.example.effectivetraining.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "day")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    @Column(unique = true)
    private LocalDate date;
    private Integer timeForTraining;

//    @JsonManagedReference
    @OneToMany(mappedBy = "day")
    private List<Set> sets;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

}
