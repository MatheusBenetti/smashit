package com.totex.smashit.infra.dto.player;

import com.totex.smashit.core.enums.PlayerLevel;
import jakarta.validation.constraints.*;

public record UpdatePlayerRequest(
        String name,
        String username,
        String email,
        String phone,
        PlayerLevel playerLevel,
        String city,
        String state,
        String country,
        Integer wins,
        Integer losses,
        Double winRate
) {
}
