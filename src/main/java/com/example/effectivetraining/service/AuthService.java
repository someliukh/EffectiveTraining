package com.example.effectivetraining.service;

import com.example.effectivetraining.dto.auth.request.AuthRequest;
import com.example.effectivetraining.dto.auth.responce.AuthResponse;
import com.example.effectivetraining.dto.auth.request.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import javax.mail.MessagingException;
import java.io.IOException;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse authenticate(AuthRequest request);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
