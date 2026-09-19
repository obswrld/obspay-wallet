package com.obspay.authservice.mapper;

import com.obspay.authservice.domain.User;
import com.obspay.authservice.dto.response.UserRegistrationResponse;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UserRegistrationResponse mapToResponse(User user) {
        return UserRegistrationResponse.builder()
            .id(user.getId())
            .email(user.getEmail())
            .role(user.getRole())
            .isEmailVerified(user.isEmailVerified())
            .isAccountLocked(user.isAccountLocked())
            .createdAt(user.getCreatedAt())
            .build();
    }
}