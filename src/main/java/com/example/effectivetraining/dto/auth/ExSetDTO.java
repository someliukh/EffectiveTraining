package com.example.effectivetraining.dto.auth;

import com.example.effectivetraining.entity.gym.Exercise;
import com.example.effectivetraining.entity.gym.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExSetDTO {

    private Exercise exercises;
    private List<Set> sets;

}
