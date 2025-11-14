package com.totex.smashit.infra.dto.match;

import com.totex.smashit.core.enums.MatchStatus;
import com.totex.smashit.core.enums.MatchType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record UpdateMatchRequest(
        LocalDate date,
        LocalTime hour,
        Long courtId,
        List<Long> players,
        MatchStatus matchStatus,
        MatchType matchType
) {}
