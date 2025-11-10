package com.totex.smashit.infra.dto.player;

import com.totex.smashit.core.enums.PlayerLevel;
import jakarta.validation.constraints.*;

public record PlayerDto(
        Long id,

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Username is required")
        String username,

        @NotBlank(message = "Password is required")
        @Size(min = 6, message = "Password must be at least 6 characters long")
        String password,

        @Email(message = "Invalid email format")
        String email,

        @Pattern(regexp = "\\d{10,15}", message = "Phone must contain only digits")
        String phone,

        @NotNull(message = "Player level is required")
        PlayerLevel playerLevel,

        @NotBlank(message = "City is required")
        String city,

        @NotBlank(message = "State is required")
        String state,

        @NotBlank(message = "Country is required")
        String country,

        Integer wins,
        Integer losses,
        Double winRate
) {}
