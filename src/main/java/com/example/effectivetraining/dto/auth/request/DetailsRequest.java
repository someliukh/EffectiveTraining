package com.example.effectivetraining.dto.auth.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailsRequest {

    private String firstname;
    private String lastname;

    private Integer age;
    private Float weight;
    private Integer height;

}
