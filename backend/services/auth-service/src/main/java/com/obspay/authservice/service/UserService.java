package com.obspay.authservice.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.obspay.authservice.mapper.Mapper;
import com.obspay.authservice.exception.DuplicateException;
import com.obspay.authservice.domain.User;
import com.obspay.authservice.repository.UserRepository;
import com.obspay.authservice.dto.request.UserRegisterRequest;
import com.obspay.authservice.dto.response.UserRegistrationResponse;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Mapper mapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, Mapper mapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    public UserRegistrationResponse registerUser(UserRegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateException("Email already exists");
        }

        User user = User.builder()
            .email(request.getEmail())
            .passwordHash(passwordEncoder.encode(request.getPassword()))
            .build();

        User savedUser = userRepository.save(user);
        return mapper.mapToResponse(savedUser);
    }
}