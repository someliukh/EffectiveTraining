package com.example.effectivetraining.dto.auth.responce;

import com.example.effectivetraining.entity.gym.Group;
import com.example.effectivetraining.util.GroupVideoAssociation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupsResponse {
    List<Group> filteredGroups;
    List<GroupVideoAssociation> combinedGroups;
}
