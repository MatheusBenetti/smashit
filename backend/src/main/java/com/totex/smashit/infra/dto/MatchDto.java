package com.totex.smashit.infra.dto;

import com.totex.smashit.core.entities.court.Court;
import com.totex.smashit.core.entities.player.Player;
import com.totex.smashit.core.enums.MatchStatus;
import com.totex.smashit.core.enums.MatchType;

import java.time.LocalDate;
import java.time.LocalTime;

public record MatchDto(
        Long id,
        LocalDate date,
        LocalTime hour,
        Court courtId,
        Player players,
        MatchStatus matchStatus,
        MatchType matchType
) {}
