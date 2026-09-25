package com.obspay.authservice.dto.response;

import java.time.Instant;   
import java.util.UUID;
import lombok.*;

import com.obspay.authservice.domain.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistrationResponse {

    private UUID id;

    private String email;

    private Role role;

    private boolean isEmailVerified;

    private boolean isAccountLocked;

    private Instant createdAt;
}