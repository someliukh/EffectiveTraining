package com.example.effectivetraining.controller;

import com.example.effectivetraining.dto.auth.request.TrainingRequest;
import com.example.effectivetraining.dto.auth.responce.GroupsResponse;
import com.example.effectivetraining.dto.auth.responce.TrainingResponse;
import com.example.effectivetraining.entity.gym.Day;
import com.example.effectivetraining.entity.gym.Group;
import com.example.effectivetraining.entity.gym.Youtube;
import com.example.effectivetraining.mapper.TrainToEntityMapper;
import com.example.effectivetraining.repository.DayRepository;
import com.example.effectivetraining.repository.GroupRepository;
import com.example.effectivetraining.repository.ProfileRepository;
import com.example.effectivetraining.util.GroupVideoAssociation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/train")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class TrainingController {

    private final ProfileRepository profileRepository;
    private final DayRepository dayRepository;
    private final TrainToEntityMapper mapper;
    private final GroupRepository groupRepository;

    @PreAuthorize("@authServiceImpl.hasId(#id)")
    @GetMapping("/{id}")
    public ResponseEntity<TrainingResponse> getAllUserTrainings(@PathVariable("id") Integer id) {
        TrainingResponse trainingResponse = TrainingResponse.builder()
                .id(id)
                .details(profileRepository.findByUId(id))
                .day(dayRepository.findAllByUserId(id))
                .build();
        trainingResponse.getDay().forEach(day -> day.getSets().forEach(set -> set.getExercise().setSets(null)));
        trainingResponse.getDay().forEach(day -> day.getSets().forEach(set -> set.setDay(null)));

        return ResponseEntity.ok(trainingResponse);
    }

    @PreAuthorize("@authServiceImpl.hasId(#id)")
    @PostMapping("/{id}/add")
    public ResponseEntity<Day> postTraining(@PathVariable("id") Integer id, @RequestBody TrainingRequest request) {
        Day day = mapper.trainToEntity(id, request);
        day.setUser(null);
        day.getSets().forEach(set -> set.getExercise().setSets(null));
        day.getSets().forEach(set -> set.setDay(null));
        return ResponseEntity.ok(day);
    }

    @GetMapping
    public ResponseEntity<GroupsResponse> getAllAvailableTrainings() {

        List<Group> groupList = groupRepository.findAll();

        // Створюємо мапу для підрахунку кількості кожного відео
        Map<Youtube, Integer> youtubeCountMap = new HashMap<>();

        // Заповнюємо мапу
        for (Group group : groupList) {
            for (Youtube youtube : group.getYoutube()) {
                youtubeCountMap.put(youtube, youtubeCountMap.getOrDefault(youtube, 0) + 1);
            }
        }

        // Фільтруємо групи, щоб залишити лише ті, які мають унікальні відео
        List<Group> filteredGroups = groupList.stream()
                .filter(group -> group.getYoutube().stream()
                        .allMatch(youtube -> youtubeCountMap.get(youtube) == 1))
                .collect(Collectors.toList());

        List<Group> groupList2 = groupRepository.findAll();

        Map<Long, List<Group>> youtubeToGroupsMap = new HashMap<>();

        // Заповнюємо мапу
        for (Group group : groupList2) {
            for (Youtube youtube : group.getYoutube()) {
                youtubeToGroupsMap.computeIfAbsent(youtube.getId(), k -> new ArrayList<>()).add(group);
            }
        }

        // Створюємо список для зберігання асоціацій груп і спільного відео
        List<GroupVideoAssociation> groupVideoAssociations = new ArrayList<>();

        // Витягуємо асоціації груп, які мають спільне відео
        for (Map.Entry<Long, List<Group>> entry : youtubeToGroupsMap.entrySet()) {
            List<Group> groups = entry.getValue();
            if (groups.size() >= 2) {
                Youtube commonVideo = findYoutubeById(entry.getKey(), groups.get(0));
                groupVideoAssociations.add(new GroupVideoAssociation(groups, commonVideo));
            }
        }

        filteredGroups.forEach(group -> group.getYoutube().forEach(youtube -> youtube.setGroup(null)));
        filteredGroups.forEach(group -> group.getExercises().forEach(exercise -> exercise.setSets(null)));
        groupVideoAssociations.forEach(group -> group.getCommonVideo().setGroup(null));
        groupVideoAssociations.forEach(groups -> groups.getGroups().forEach(group -> group.setYoutube(null)));

        return ResponseEntity.ok(GroupsResponse.builder()
                .filteredGroups(filteredGroups)
                .combinedGroups(groupVideoAssociations)
                .build());
    }

    private Youtube findYoutubeById(Long id, Group group) {
        return group.getYoutube().stream().filter(youtube -> youtube.getId().equals(id)).findFirst().orElse(null);
    }


}
