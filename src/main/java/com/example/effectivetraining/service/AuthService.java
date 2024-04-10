package com.example.effectivetraining.service;

import com.example.effectivetraining.dto.auth.AuthRequest;
import com.example.effectivetraining.dto.auth.AuthResponse;
import com.example.effectivetraining.dto.auth.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import javax.mail.MessagingException;
import java.io.IOException;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse authenticate(AuthRequest request);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
