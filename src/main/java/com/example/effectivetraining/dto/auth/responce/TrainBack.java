package com.example.effectivetraining.dto.auth.responce;

import com.example.effectivetraining.dto.auth.ExSetDTO;
import com.example.effectivetraining.entity.gym.Group;
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
public class TrainBack {

    private Integer id;
    private String title;
    private Integer timeForTraining;
    private LocalDate date;
    private List<Group> groups;
    private List<ExSetDTO> exSetDTOList;

}
