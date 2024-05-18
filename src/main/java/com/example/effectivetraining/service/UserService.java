package com.example.effectivetraining.service;

import com.example.effectivetraining.entity.user.Details;
import com.example.effectivetraining.entity.user.User;

import java.util.List;

public interface UserService {

    User getUserById(Integer id);

    List<User> getAllUser();
    Details updateUserDetails(Integer id, Details details);

}
