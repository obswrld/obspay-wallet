package com.obspay.authservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("isEmailVerified")
    private boolean isEmailVerified;

    @JsonProperty("isAccountLocked")
    private boolean isAccountLocked;

    private Instant createdAt;
}