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
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String groupName;

    @JsonManagedReference
    @OneToMany(mappedBy = "group")
    private List<Exercise> exercises;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "youtube_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Youtube> youtube;
}
