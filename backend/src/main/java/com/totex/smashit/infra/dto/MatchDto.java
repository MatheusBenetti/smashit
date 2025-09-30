package com.totex.smashit.infra.dto;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.enums.MatchStatus;
import com.totex.smashit.core.enums.MatchType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record MatchDto(
        Long id,
        @NotNull LocalDate date,
        @NotNull LocalTime hour,
        @NotNull Court courtId,
        List<Player> players,
        @NotNull MatchStatus matchStatus,
        MatchType matchType
) {}
