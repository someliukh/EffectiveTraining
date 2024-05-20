package com.example.effectivetraining.mapper;

import com.example.effectivetraining.dto.auth.ExerciseDTO;
import com.example.effectivetraining.dto.auth.request.TrainingRequest;
import com.example.effectivetraining.entity.gym.Day;
import com.example.effectivetraining.entity.gym.Exercise;
import com.example.effectivetraining.entity.gym.Set;
import com.example.effectivetraining.repository.*;
import com.example.effectivetraining.service.UserService;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Component
public class TrainToEntityMapper {

    private final UserService userService;
    private final ExRepository exRepository;
    private final GroupRepository groupRepository;
    private final YoutubeRepository youtubeRepository;
    private final SetRepository setRepository;
    private final DayRepository dayRepository;

    public Day trainToEntity(Integer id, TrainingRequest request) {
        List<Set> setList = new ArrayList<>();

        request.getExercises().forEach(ex -> {
            List<Set> tempSetList = new ArrayList<>();
            ex.getSets().forEach(set -> {
                Set newSet = Set.builder()
                        .setNum(set.getSetNum())
                        .setWeight(set.getSetWeight())
                        .build();
                newSet.setExercise(exRepository.findByExerciseName(ex.getExName()));
                tempSetList.add(newSet);
            });
            setList.addAll(tempSetList);
        });

        Day day = Day.builder()
                .title(request.getTitle())
                .date(request.getDate())
                .timeForTraining(request.getTimeForTraining())
                .user(userService.getUserById(id))
                .build();

        Day newDay = dayRepository.save(day);

        setList.forEach(set -> set.setDay(newDay));
        List<Set> newSet2 = setRepository.saveAll(setList);
        newDay.setSets(newSet2);
        dayRepository.save(newDay);

        return dayRepository.findByDate(request.getDate(), id);
    }

}
