package com.example.effectivetraining.dto.auth.responce;

import com.example.effectivetraining.entity.user.Details;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailsResponse {

    private Details details;

}
