package com.example.effectivetraining.entity.gym;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String exerciseName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

//    @JsonManagedReference
    @OneToMany(mappedBy = "exercise")
    private List<Set> sets;

}
