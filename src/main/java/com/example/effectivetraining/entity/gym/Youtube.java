package com.example.effectivetraining.entity.gym;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "youtube")
public class Youtube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String exLink;

    @ManyToMany(mappedBy = "youtube")
    private List<Group> group;

}
