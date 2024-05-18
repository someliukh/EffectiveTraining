package com.example.effectivetraining.dto.auth.request;

import com.example.effectivetraining.dto.auth.ExerciseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainingRequest {

    private String youtubeLink;
    private String title;
    private Integer timeForTraining;
    private LocalDate date;
    private List<ExerciseDTO> exercises;

}
