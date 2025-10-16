package com.totex.smashit.core.entities.player;

import com.totex.smashit.core.enums.PlayerLevel;

import java.time.LocalDateTime;

public record Player(
        Long id,
        String name,
        String username,
        String password,
        String email,
        String phone,
        PlayerLevel playerLevel,
        String city,
        String state,
        String country,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Integer wins,
        Integer losses,
        Double winRate
) {}
