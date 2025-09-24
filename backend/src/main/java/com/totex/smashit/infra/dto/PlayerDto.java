package com.totex.smashit.infra.dto;

import com.totex.smashit.core.enums.PlayerLevel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PlayerDto(
        Long id,
        @NotNull String name,
        @NotNull String username,
        @NotNull  String password,
        @Email String email,
        String phone,
        PlayerLevel playerLevel,
        @NotNull String city,
        @NotNull String state,
        @NotNull String country,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
