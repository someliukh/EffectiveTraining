package com.example.effectivetraining.entity.user;

import com.example.effectivetraining.enums.Sex;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "details")
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstname;
    private String lastname;

    private Integer age;
    private Float weight;
    private Integer height;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private Float kkal;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

}
