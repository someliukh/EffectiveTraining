package com.example.effectivetraining.service.impl;

import com.example.effectivetraining.entity.user.Details;
import com.example.effectivetraining.entity.user.User;
import com.example.effectivetraining.repository.ProfileRepository;
import com.example.effectivetraining.repository.UserRepository;
import com.example.effectivetraining.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAllWithMemberAccess();
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElse(null);
    }

    @Override
    public Details updateUserDetails(Integer id, Details details) {
        details.setUser(userRepository.findById(id).get());
        Details oldDetails = profileRepository.findByUId(id);
        if (oldDetails != null) {
            details.setId(oldDetails.getId());
            oldDetails = details;
            details = profileRepository.save(oldDetails);
        } else
            details = profileRepository.save(details);
        return details;
    }

}
