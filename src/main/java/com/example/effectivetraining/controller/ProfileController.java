package com.example.effectivetraining.controller;

import com.example.effectivetraining.dto.auth.responce.DetailsResponse;
import com.example.effectivetraining.entity.user.Details;
import com.example.effectivetraining.entity.user.User;
import com.example.effectivetraining.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
public class ProfileController {

    private final UserService userService;

    @PreAuthorize("@authServiceImpl.hasId(#id)")
    @GetMapping("/{id}")
    public ResponseEntity<DetailsResponse> getProfileById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(new DetailsResponse(user.getDetails()));
    }

    @PreAuthorize("@authServiceImpl.hasId(#id)")
    @PatchMapping("/{id}/edit")
    public ResponseEntity<DetailsResponse> editProfileById(@PathVariable("id") Integer id, @RequestBody Details details) {
        Details newDetails = userService.updateUserDetails(id, details);
        return ResponseEntity.ok(new DetailsResponse(newDetails));
    }

}
