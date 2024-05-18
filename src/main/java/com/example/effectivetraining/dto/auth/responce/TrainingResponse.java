package com.example.effectivetraining.dto.auth.responce;

import com.example.effectivetraining.entity.gym.Day;
import com.example.effectivetraining.entity.user.Details;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainingResponse {

    private Integer id;
    private Details details;
    private List<Day> day;

}
